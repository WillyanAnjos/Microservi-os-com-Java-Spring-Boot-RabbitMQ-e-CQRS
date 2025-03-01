package br.com.beautique.ms_sync.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncLogger {

    private static final Logger logger = LoggerFactory.getLogger(SyncLogger.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void trace(String message, Object ... args) {
        logger.trace(message, args);
    }
}
