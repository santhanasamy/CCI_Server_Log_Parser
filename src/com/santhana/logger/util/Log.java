
package com.santhana.logger.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class Log {

    public static final String LOGGER_NAME = "TS";

    public static final Logger LOG = LoggerFactory.getLogger(LOGGER_NAME);

    public static void initialize() {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream(new File(AppConstants.LOGGER_CONFIG_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogManager.getLogManager().getLogger(LOGGER_NAME).setLevel(Level.ALL);
    }


    public static final void printDLog(String aTAG, String aMsg, String... aStr) {
        if (null == aStr || aStr.length == 0) {
            LOG.debug(aTAG + " [" + aMsg + "]");
        } else {
            LOG.debug(aTAG + " [" + aMsg + "]" + Arrays.asList(aStr));
        }
    }

    public static final void printELog(String aTAG, String aMsg, String... aStr) {

        if (null == aStr || aStr.length == 0) {
            LOG.error(aTAG + " [" + aMsg + "]");
        } else {
            LOG.error(aTAG + " [" + aMsg + "]" + Arrays.asList(aStr));
        }

    }

    public static final void printILog(String aTAG, String aMsg, String... aStr) {

        if (null == aStr || aStr.length == 0) {
            LOG.info(aTAG + " [" + aMsg + "]");
        } else {
            LOG.info(aTAG + " [" + aMsg + "]" + Arrays.asList(aStr));
        }
    }

    public static final void printSys(String aMsg, String... aStr) {

        int length = aStr.length;

        if (length == 1) {
            System.out.println("[" + aMsg + "][" + aStr[0] + "]");
        } else if (length == 2) {
            System.out.println("[" + aMsg + "][" + aStr[0] + "," + aStr[1] + "]");
        } else if (length == 3) {
            System.out.println("[" + aMsg + "][" + aStr[0] + "," + aStr[1] + "," + aStr[2] + "]");
        } else {
            System.out.println("[" + aMsg + "]" + Arrays.asList(aStr));
        }
    }

    public static final void printException(String aTAG, String aMsg, Exception aExc) {

        if (null == aExc) {
            return;
        }
        LOG.error(aTAG + " [Exception][" + aMsg + "][" + aExc.getMessage() + "]");
        printStackTrace(aExc);
    }

    public static final void printException(String aTAG, Exception aException) {

        if (null == aException) {
            return;
        }
        LOG.error(aTAG + " [Exception][Detail][" + aException.getMessage() + "]");

        printStackTrace(aException);
    }

    public static void printStackTrace(Exception e) {
        e.printStackTrace();
    }

}
