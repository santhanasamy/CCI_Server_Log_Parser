package com.santhana.logger.parser;

import com.google.gson.JsonParseException;
import com.santhana.logger.model.*;
import com.santhana.logger.parser.ParseConstants.Common;
import com.santhana.logger.util.Log;
import com.santhana.logger.util.TextUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.Stack;

import static com.santhana.logger.parser.LogParser.TAG;
import static com.santhana.logger.parser.ParseConstants.COMMAND_DATE_FORMAT;
import static com.santhana.logger.parser.ParseConstants.JSON_CONVERTER;

public class ParseUtils {

    private static long mLastTimeStamp = -1;

    public static final void prepareMsg(BufferedReader aReader, Map<Long, Message> aLinkedMap,
                                        FlowType aFlowType) {
        try {
            String lLine;
            StringBuilder lBuilder = null;
            boolean isOpened = false;
            Stack<String> lStack = new Stack<>();
            while ((lLine = aReader.readLine()) != null) {
                if ((!isOpened && !lLine.startsWith(Common.OPEN_BRACE)) || TextUtils.isEmpty(lLine)) {
                    continue;
                }
                if (lLine.startsWith(Common.OPEN_BRACE)) {
                    lStack.push(Common.OPEN_BRACE);
                    isOpened = true;
                    if (null == lBuilder) {
                        lBuilder = new StringBuilder(Common.OPEN_BRACE);
                    } else {
                        lBuilder.append(Common.OPEN_BRACE);
                    }
                } else if (lLine.startsWith(Common.CLOSE_BRACE)) {
                    lStack.pop();
                    lBuilder.append(Common.CLOSE_BRACE);
                    if (lStack.isEmpty()) {
                        break;
                    }
                } else {
                    lBuilder.append(lLine);
                }
            }
            if (null != lBuilder) {
                // Log.printDLog(TAG, "Parsed Command ", lBuilder.toString());

                Message lCommand = null;
                boolean isFailed = false;
                try {
                    lCommand = JSON_CONVERTER.fromJson(lBuilder.toString(), Command.class);
                } catch (JsonParseException aException) {
                    isFailed = true;
                    //aException.printStackTrace();
                    Log.printELog(TAG, "1.Parsing Error ", Command.class.getSimpleName());
                }
                if (isFailed) {
                    isFailed = false;
                    try {
                        lCommand = JSON_CONVERTER.fromJson(lBuilder.toString(), Command1.class);
                    } catch (JsonParseException aException) {
                        isFailed = true;
                        Log.printELog(TAG, "2. Parsing Error ", Command1.class.getSimpleName());
                    }
                }
                if (isFailed) {
                    isFailed = false;
                    try {
                        lCommand = JSON_CONVERTER.fromJson(lBuilder.toString(), Command2.class);
                    } catch (JsonParseException aException) {
                        isFailed = true;
                        Log.printELog(TAG, "3. Parsing Error ", Command2.class.getSimpleName());
                    }
                }
                if (isFailed) {
                    isFailed = false;
                    try {
                        lCommand = JSON_CONVERTER.fromJson(lBuilder.toString(), Command3.class);
                    } catch (JsonParseException aException) {
                        isFailed = true;
                        Log.printELog(TAG, "4. Parsing Error ", Command3.class.getSimpleName());
                    }
                }
                //game_instance_id -> Integer to String In -> ("type": "notification",  "message_id": "notify_exception")
                if (isFailed) {
                    isFailed = false;
                    try {
                        lCommand = JSON_CONVERTER.fromJson(lBuilder.toString(), Command4.class);
                    } catch (JsonParseException aException) {
                        Log.printELog(TAG, "5. Parsing Error ", Command4.class.getSimpleName());
                    }
                }


                if (null == lCommand) {
                    Log.printDLog(TAG, "Parsed Command - " + lBuilder.toString());
                    return;
                }
                String lTimeStampStr = lCommand.getTimestamp();
                Log.printDLog(TAG, "Parsed Command [Time, Command]", lTimeStampStr, lCommand.getMessage_id());
                long lTimeStamp = -1;
                if (!TextUtils.isEmpty(lTimeStampStr)) {
                    try {
                        mLastTimeStamp = lTimeStamp = COMMAND_DATE_FORMAT.parse(lTimeStampStr).getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (lTimeStamp != -1) {

                        while (aLinkedMap.containsKey(lTimeStamp)) {
                            lTimeStamp += 1;
                        }
                        mLastTimeStamp = lTimeStamp;
                        aLinkedMap.put(lTimeStamp, lCommand);
                        lCommand.setFlowType(aFlowType);
                    }
                } else {
                    if (-1 != mLastTimeStamp) {
                        mLastTimeStamp = mLastTimeStamp + 1;
                        aLinkedMap.put(mLastTimeStamp, lCommand);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception aExc) {
            aExc.printStackTrace();
        }
    }
}
