package com.test.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging Utils
 */

public class LogUtils {
    private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    /**
     * Log level: info
     *
     * @param message
     */
    public static void info(String message) {
        logger.info(message);
    }

    /**
     * Log level: info with parameters
     *
     * @param message
     * @param args
     */
    public static void info(String message, Object... args) {
        logger.info(message, args);
    }

    /**
     * Log level: debug
     *
     * @param message
     */
    public static void debug(String message) {
        logger.debug(message);
    }

    /**
     * Log level: debug with parameters
     *
     * @param message
     * @param args
     */
    public static void debug(String message, Object... args) {
        logger.debug(message, args);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void error(String message, Object... args) {
        logger.error(message, args);
    }

    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void warn(String message, Object... args) {
        logger.warn(message, args);
    }
}
