package com.santhana.logger.util;

import javafx.scene.image.Image;

import static com.santhana.logger.util.ImageUtils.MessageID.*;

public class ImageUtils {

    //Creating an image
    public static Image FORWARD_IMAGE = null;

    public static Image BACKWARD_IMAGE = null;

    public static Image BACKWARD_IMAGE_TO_DASH_IMAGE = null;

    public static Image ADD_PLAYER_IMAGE = null;

    public static Image CLEAR_PLAYER_LIST_IMAGE = null;

    public static Image PLAYER_LIST_IMAGE = null;

    public static Image PLAYER_CHANGE_IMAGE = null;

    public static Image BALL_IMAGE = null;

    public static Image UPDATE_SCORE_IMAGE = null;

    public static Image NOTIFY_BALL_LAUNCH_IMAGE = null;

    public static Image GAME_START_IMAGE = null;

    public static Image GAME_STOP_IMAGE = null;

    public static Image EXCEPTION_IMAGE = null;
    public static Image START_SESSION_IMAGE = null;
    public static Image STOP_SESSION_IMAGE = null;

    public static Image UPDATE_DEVICE_CONFIG_IMAGE = null;
    public static Image UPDATE_GAME_CONFIG_IMAGE = null;

    public static Image GAME_SET_FG_STATE = null;

    public static final void initImages(Class clazz) {
        FORWARD_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_forward.png"));
        BACKWARD_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_backward.png"));
        BACKWARD_IMAGE_TO_DASH_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_game_to_dash.png"));

        ADD_PLAYER_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_add_player.png"));
        CLEAR_PLAYER_LIST_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_clear_player_list.png"));
        PLAYER_LIST_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_player_list.png"));
        PLAYER_CHANGE_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_player_change.png"));


        BALL_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_ball.png"));
        UPDATE_SCORE_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_game_score.png"));
        NOTIFY_BALL_LAUNCH_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_notify_ball_launch.png"));


        GAME_START_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_game_start.png"));
        GAME_STOP_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_game_stop.png"));


        EXCEPTION_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_exception.png"));
        START_SESSION_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_start_session.png"));
        STOP_SESSION_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_stop_session.png"));

        UPDATE_DEVICE_CONFIG_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_update_device_config.png"));
        UPDATE_GAME_CONFIG_IMAGE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_update_game_config.png"));

        GAME_SET_FG_STATE = new Image(clazz.getResourceAsStream("/com/santhana/logger/res/icons/ic_foreground.png"));

    }

    interface MessageID {

        enum Player {

            ADD_PLAYER("add_player", ADD_PLAYER_IMAGE),
            UPDATE_PLAYER("update_player", ADD_PLAYER_IMAGE),
            NOTIFY_PLAYER_ADDED("player_added", ADD_PLAYER_IMAGE),

            GET_PLAYER_LIST("player_list", PLAYER_CHANGE_IMAGE),

            PLAYER_LIST_CLEAR("clear_player_list", CLEAR_PLAYER_LIST_IMAGE),
            PLAYER_LIST_CLEARED("player_list_cleared", CLEAR_PLAYER_LIST_IMAGE),

            NOTIFY_PLAYER_CHANGE("notify_player_change", PLAYER_CHANGE_IMAGE),
            UPDATE_PLAYER_TEES("update_player_tees", null);

            private final String msgIDString;
            private final Image msgImage;

            Player(String aMsgIDString, Image aImage) {
                msgIDString = aMsgIDString;
                msgImage = aImage;
            }

            public String getMsgIDString() {
                return msgIDString;
            }

            public Image getMsgImage() {
                return msgImage;
            }
        }

        enum GameState {

            NOTIFY_GAME_STARTED("notify_game_started", GAME_START_IMAGE),
            GAME_STARTED("game_started", GAME_START_IMAGE),
            GAME_STOPPED("game_stopped", GAME_STOP_IMAGE),

            UPDATE_GAME_CONFIG("update_game_config", UPDATE_GAME_CONFIG_IMAGE),
            GAME_CONFIG_UPDATED("game_config_updated", UPDATE_GAME_CONFIG_IMAGE),

            UPDATE_DEVICE_CONFIG("update_device_config", UPDATE_DEVICE_CONFIG_IMAGE),
            DEVICE_CONFIG_UPDATED("device_config_updated", UPDATE_DEVICE_CONFIG_IMAGE),

            STOP_GAME_INSTANCE("stop_game_instance", GAME_STOP_IMAGE),

            BEGIN_SESSION("begin_session", START_SESSION_IMAGE),
            END_SESSION("end_session", STOP_SESSION_IMAGE),

            SESSION_STARTED("session_started", START_SESSION_IMAGE),
            SESSION_ENDED("session_ended", STOP_SESSION_IMAGE),

            UPDATE_BALL_POSITION("update_ball_pos", BALL_IMAGE),
            BALL_POSITION_UPDATED("ball_position_updated", BALL_IMAGE),

            NOTIFY_SCORE("notify_score", UPDATE_SCORE_IMAGE),
            NOTIFY_BALL_LAUNCH("notify_ball_launch", NOTIFY_BALL_LAUNCH_IMAGE),

            SET_FG_STATE("set_foreground_state", UPDATE_SCORE_IMAGE),
            GAME_SET_TO_FG_STATE("game_set_to_foreground", NOTIFY_BALL_LAUNCH_IMAGE);

            private final String msgIDString;
            private final Image msgImage;

            GameState(String aMsgIDString, Image aImage) {
                msgIDString = aMsgIDString;
                msgImage = aImage;
            }

            public String getMsgIDString() {
                return msgIDString;
            }

            public Image getMsgImage() {
                return msgImage;
            }
        }
    }

    public static final Image getImageForMsgType(String aMsgType) {

        if (aMsgType.equals(Player.ADD_PLAYER.msgIDString)) {
            return Player.ADD_PLAYER.getMsgImage();
        } else if (aMsgType.equals(Player.UPDATE_PLAYER.msgIDString)) {
            return Player.UPDATE_PLAYER.getMsgImage();
        } else if (aMsgType.equals(Player.NOTIFY_PLAYER_ADDED.msgIDString)) {
            return Player.NOTIFY_PLAYER_ADDED.getMsgImage();
        } else if (aMsgType.equals(Player.GET_PLAYER_LIST.msgIDString)) {
            return Player.GET_PLAYER_LIST.getMsgImage();
        } else if (aMsgType.equals(Player.PLAYER_LIST_CLEAR.msgIDString)) {
            return Player.PLAYER_LIST_CLEAR.getMsgImage();
        } else if (aMsgType.equals(Player.PLAYER_LIST_CLEARED.msgIDString)) {
            return Player.PLAYER_LIST_CLEARED.getMsgImage();
        } else if (aMsgType.equals(Player.NOTIFY_PLAYER_CHANGE.msgIDString)) {
            return Player.NOTIFY_PLAYER_CHANGE.getMsgImage();
        } else if (aMsgType.equals(Player.UPDATE_PLAYER_TEES.msgIDString)) {
            return Player.UPDATE_PLAYER_TEES.getMsgImage();
        }
        //
        else if (aMsgType.equals(GameState.NOTIFY_GAME_STARTED.msgIDString)) {
            return GameState.NOTIFY_GAME_STARTED.getMsgImage();
        } else if (aMsgType.equals(GameState.GAME_STARTED.msgIDString)) {
            return GameState.GAME_STARTED.getMsgImage();
        } else if (aMsgType.equals(GameState.GAME_STOPPED.msgIDString)) {
            return GameState.GAME_STOPPED.getMsgImage();
        }
        //
        else if (aMsgType.equals(GameState.SET_FG_STATE.msgIDString)) {
            return GameState.SET_FG_STATE.getMsgImage();
        } else if (aMsgType.equals(GameState.GAME_SET_TO_FG_STATE.msgIDString)) {
            return GameState.GAME_SET_TO_FG_STATE.getMsgImage();
        }

        //
        else if (aMsgType.equals(GameState.UPDATE_GAME_CONFIG.msgIDString)) {
            return GameState.UPDATE_GAME_CONFIG.getMsgImage();
        } else if (aMsgType.equals(GameState.GAME_CONFIG_UPDATED.msgIDString)) {
            return GameState.GAME_CONFIG_UPDATED.getMsgImage();
        }
        //
        else if (aMsgType.equals(GameState.UPDATE_DEVICE_CONFIG.msgIDString)) {
            return GameState.UPDATE_DEVICE_CONFIG.getMsgImage();
        } else if (aMsgType.equals(GameState.DEVICE_CONFIG_UPDATED.msgIDString)) {
            return GameState.DEVICE_CONFIG_UPDATED.getMsgImage();
        } else if (aMsgType.equals(GameState.STOP_GAME_INSTANCE.msgIDString)) {
            return GameState.STOP_GAME_INSTANCE.getMsgImage();
        } else if (aMsgType.equals(GameState.BEGIN_SESSION.msgIDString)) {
            return GameState.BEGIN_SESSION.getMsgImage();
        } else if (aMsgType.equals(GameState.END_SESSION.msgIDString)) {
            return GameState.END_SESSION.getMsgImage();
        } else if (aMsgType.equals(GameState.SESSION_STARTED.msgIDString)) {
            return GameState.SESSION_STARTED.getMsgImage();
        } else if (aMsgType.equals(GameState.SESSION_ENDED.msgIDString)) {
            return GameState.SESSION_ENDED.getMsgImage();
        }
        //
        else if (aMsgType.equals(GameState.UPDATE_BALL_POSITION.msgIDString)) {
            return GameState.UPDATE_BALL_POSITION.getMsgImage();
        } else if (aMsgType.equals(GameState.BALL_POSITION_UPDATED.msgIDString)) {
            return GameState.BALL_POSITION_UPDATED.getMsgImage();
        } else if (aMsgType.equals(GameState.NOTIFY_SCORE.msgIDString)) {
            return GameState.NOTIFY_SCORE.getMsgImage();
        } else if (aMsgType.equals(GameState.NOTIFY_BALL_LAUNCH.msgIDString)) {
            return GameState.NOTIFY_BALL_LAUNCH.getMsgImage();
        }

        return null;
    }
}
