package com.tw.examples.securelog;

public class SecureLogger {
    private Appender appender;

    public SecureLogger(Appender appender) {
        this.appender = appender;
    }

    public void info(Object object) {
        String asString = isSensitive(object) ? "***" : object.toString();
        appender.append(asString);
    }

    private boolean isSensitive(Object object) {
        return object.getClass().isAnnotationPresent(Sensitive.class);
    }
}
