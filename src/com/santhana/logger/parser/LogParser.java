package com.santhana.logger.parser;

import com.santhana.logger.model.FlowType;
import com.santhana.logger.model.Message;
import com.santhana.logger.parser.ParseConstants.Common;
import com.santhana.logger.parser.ParseConstants.ConnectionMeta;
import com.santhana.logger.parser.ParseConstants.MsgType;
import com.santhana.logger.util.Log;
import com.santhana.logger.util.TextUtils;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.santhana.logger.parser.ParseConstants.MsgFlow;

public class LogParser {

    public static final String TAG = LogParser.class.getSimpleName();

    private static final LogParser sParser = new LogParser();

    public static LogParser getInstance() {
        return sParser;
    }


    public void parse(String aLogFileName) {
        if (TextUtils.isEmpty(aLogFileName)) {
            Log.printILog(TAG, "Invalid file name to parse!");
        }
        parse(new File(aLogFileName));
    }

    public Map<Long, Message> parse(File aSelectedFile) {

        if (null == aSelectedFile || !aSelectedFile.exists()) {
            Log.printILog(TAG, "Invalid file to parse!");
            return null;
        }

        LinkedHashMap<Long, Message> lMap = new LinkedHashMap<>();

        BufferedReader lReader = null;
        try {
            lReader = new BufferedReader(new FileReader(aSelectedFile));
            String lLine;
            while ((lLine = lReader.readLine()) != null) {
                parseLine(lLine, lReader, lMap);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != lReader) {
                try {
                    lReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        int lParsedCount = (null != lMap) ? lMap.values().size() : 0;
        Log.printILog(TAG, "Total Msg Received vs Parsed", "", "" + lParsedCount);
        return lMap;
    }


    private void parseLine(String aLine, BufferedReader aReader, Map<Long, Message> aTreeMap) {

        // 11:56:11 AM Server: LNGAMING-313
        if (aLine.contains(ConnectionMeta.CONNECTED_SERVER_CONNECTION)) {
            String[] lArray = aLine.split(" ");
            String lServerName = "";
            if (lArray.length >= 4) {
                lServerName = lArray[3];
            }
        }

        // 11:56:11 AM Dashboard Connection: 10.101.173.10:30002
        else if (aLine.contains(ConnectionMeta.SERVER_DASH_BOARD_CONNECTION)) {

            String[] lArray = aLine.split(" ");
            String lTime = "";
            if (lArray.length >= 2) {
                lTime = lArray[0] + lArray[1];
            }
            String lDashBoardAddress = "";
            if (lArray.length >= 5) {
                lDashBoardAddress = lArray[4];
            }
        }

        //12:06:01 PM Dashboard client dash6865 connected: 10.101.60.13:56012
        else if (aLine.contains(ConnectionMeta.SERVER_DASH_BOARD_CLIENT_CONNECTION)
                && aLine.contains(Common.CONNECTED)) {
            String[] lArray = aLine.split(" ");

            String lDashboardID = "";
            if (lArray.length >= 5) {
                lDashboardID = lArray[4];
            }

            String lDashboardIP = "";
            if (lArray.length >= 7) {
                lDashboardIP = lArray[6];
            }
        }

        //12:06:37 PM Game instance (game3896) connected: 10.101.173.10:50574
        else if (aLine.contains(ConnectionMeta.GAME_INSTANCE_CONNECTION) && aLine.contains(Common.CONNECTED)) {
            String[] lArray = aLine.split(" ");

            String lGameID = "";
            if (lArray.length >= 5) {
                lGameID = lArray[4];
            }

            String lGameServerIP = "";
            if (lArray.length >= 7) {
                lGameServerIP = lArray[6];
            }
        }

        // Received from game [NOTIFICATION, EXCEPTION, RESPONSE]
        else if (aLine.contains(Common.RECEIVED)
                && (aLine.contains(MsgType.NOTIFICATION)
                || aLine.contains(MsgType.EXCEPTION)
                || aLine.contains(MsgType.RESPONSE)) && aLine.contains(MsgFlow.FROM_GAME)) {
            ParseUtils.prepareMsg(aReader, aTreeMap, FlowType.FROM_GAME_TO_CCI);
        }


        // Sent [COMMAND] to the game
        else if (aLine.contains(Common.SENT)
                && aLine.contains(MsgType.COMMAND)
                && (aLine.contains(MsgFlow.TO_GAME) || aLine.contains(MsgFlow.TO_THE_GAME))) {
            ParseUtils.prepareMsg(aReader, aTreeMap, FlowType.FROM_CCI_TO_GAME);
        }

        // Sent [COMMAND, NOTIFICATION, EXCEPTION, RESPONSE] to the Dash Board
        else if (aLine.contains(Common.SENT)
                && (aLine.contains(MsgType.COMMAND)
                || aLine.contains(MsgType.NOTIFICATION)
                || aLine.contains(MsgType.EXCEPTION)
                || aLine.contains(MsgType.RESPONSE))
                && aLine.contains(MsgFlow.TO_THE_DASH)) {
            ParseUtils.prepareMsg(aReader, aTreeMap, FlowType.FROM_CCI_TO_DASH);
        }

        // Sent [NOTIFICATION] from Game to the Dash Board
        else if (aLine.contains(Common.SENT)
                && aLine.contains(MsgType.NOTIFICATION)
                && aLine.contains(MsgFlow.FROM_GAME_TO_DASH)) {
            ParseUtils.prepareMsg(aReader, aTreeMap, FlowType.FROM_GAME_TO_DASH);
        }
    }


}
