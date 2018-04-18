package com.santhana.logger.parser;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ParseConstants {

    // 2018-02-20T12:06:44.615Z
    public static SimpleDateFormat COMMAND_DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss",
            Locale.ENGLISH);

    public static final Gson JSON_CONVERTER = new Gson();

    public interface Common {
        //Group 0
        String OPEN_BRACE = "{";
        String CLOSE_BRACE = "}";

        String CONNECTED = "connected";
        String RECEIVED = "Received";
        String SENT = "Sent";
    }

    public interface MsgType {
        String NOTIFICATION = "NOTIFICATION";
        String RESPONSE = "RESPONSE";
        String COMMAND = "COMMAND";
        String EXCEPTION = "EXCEPTION";

    }

    public interface ConnectionMeta {

        String CONNECTED_SERVER_CONNECTION = "Server: LNGAMING";
        String SERVER_DASH_BOARD_CONNECTION = "Dashboard Connection";
        String SERVER_DASH_BOARD_CLIENT_CONNECTION = "Dashboard client";
        String GAME_INSTANCE_CONNECTION = "Game instance";
    }

    public interface MsgFlow {
        String FROM_GAME = "from game";
        String TO_GAME = "to game";
        String TO_THE_GAME = "to the game";
        String TO_THE_DASH = "to the dashboard";

        String FROM_GAME_TO_DASH = "from game to dashdash";

    }

    public interface Others {
        String TIME_STAMP = "\"timestamp\"";

        String MSG_ID_NOTIFY_EXCEPTION = "notify_exception";


        String NOTIFICATION = "notification";



    }
}
