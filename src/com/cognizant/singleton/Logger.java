package com.cognizant.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {
        if (LoggerHolder.INSTANCE != null) {
            throw new IllegalStateException("Instance already created. Use getInstance() method.");
        }
    }

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[" + timestamp + "] [INFO] " + message);
    }
}