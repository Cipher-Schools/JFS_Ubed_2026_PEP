package project.utils;

import java.io.IOException;

/**
 * UTILITY CLASS: LoggerClass
 * 
 * Purpose: Provides logging functionality with multiple log levels and file persistence
 * Features:
 * - Four log levels: ERROR, WARNING, INFO, DEBUG
 * - Console output for all levels
 * - File persistence for ERROR logs using FileWriterUtil
 */
public final class LoggerClass {

    public enum Level {
        ERROR, WARNING, INFO, DEBUG
    }

    // Private constructor to prevent instantiation (Utility class pattern)
    private LoggerClass() {}

    /**
     * Core logging method - handles all log level processing
     * 
     * @param level The log level (ERROR, WARNING, INFO, DEBUG)
     * @param msg The message to log
     * @param filename Optional filename for file logging (null for default behavior)
     */
    private static void log(Level level, String msg, String filename) {
        if (msg == null) { 
            msg = "null"; 
        }

        // Format the log message with timestamp and level
        String output = DateTimeUtil.getDateTime() + " [" + level + "] " + msg;

        // Console output
        if (level == Level.ERROR) {
            System.err.println(output); // Errors go to stderr
        } else {
            System.out.println(output); // Other levels go to stdout
        }

        // File persistence for ERROR level logs
        if (level == Level.ERROR) {
            try {
                // Use provided filename or default to level-based filename
                if (filename != null && !filename.isEmpty()) {
                    FileWriterUtil.writeToFile(filename, output);
                } else {
                    // Default: error.log
                    FileWriterUtil.writeToFile("error.log", output);
                }
            } catch (IOException e) {
                // If file writing fails, log to console (avoid infinite recursion)
                System.err.println("Failed to write log to file: " + e.getMessage());
            }
        }
    }

    // ==================== PUBLIC API METHODS ====================
    
    /**
     * Logs an ERROR message to console and file (default: error.log)
     * 
     * @param msg The error message to log
     */
    public static void error(String msg) {
        log(Level.ERROR, msg, null);
    }

    /**
     * Logs an ERROR message to console and specified file
     * 
     * @param msg The error message to log
     * @param filename The custom filename to write the log to
     */
    public static void error(String msg, String filename) {
        log(Level.ERROR, msg, filename);
    }

    /**
     * Logs a WARNING message to console
     * 
     * @param msg The warning message to log
     */
    public static void warning(String msg) {
        log(Level.WARNING, msg, null);
    }

    /**
     * Logs an INFO message to console
     * 
     * @param msg The info message to log
     */
    public static void info(String msg) {
        log(Level.INFO, msg, null);
    }

    /**
     * Logs a DEBUG message to console
     * 
     * @param msg The debug message to log
     */
    public static void debug(String msg) {
        log(Level.DEBUG, msg, null);
    }
}
