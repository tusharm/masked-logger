package com.tw.examples.appender;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;
import com.tw.examples.appender.masks.Mask;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

import java.util.Map;

import static java.lang.String.format;

public class MaskedEvent implements ILoggingEvent {
    private ILoggingEvent baseEvent;
    private transient String formattedMessage;

    public MaskedEvent(ILoggingEvent baseEvent) {
        this.baseEvent = baseEvent;
    }

    @Override
    public String getThreadName() {
        return baseEvent.getThreadName();
    }

    @Override
    public Level getLevel() {
        return baseEvent.getLevel();
    }

    @Override
    public String getMessage() {
        return baseEvent.getMessage();
    }

    @Override
    public Object[] getArgumentArray() {
        Object[] originalArray = baseEvent.getArgumentArray();
        String[] maskedArguments = new String[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            if (!(originalArray[i] instanceof Mask)) {
                throw new IllegalArgumentException(
                        format("Appender argument [%s] not an instance of %s", originalArray[i], Mask.class));
            }

            Mask mask = (Mask) originalArray[i];
            maskedArguments[i] = mask.value();
        }
        return maskedArguments;
    }

    @Override
    public String getFormattedMessage() {
        if (formattedMessage != null)
            return formattedMessage;

        Object[] argumentArray = getArgumentArray();
        formattedMessage = (argumentArray != null)
                ? MessageFormatter.arrayFormat(getMessage(), argumentArray).getMessage()
                : getMessage();

        return formattedMessage;
    }

    @Override
    public String getLoggerName() {
        return baseEvent.getLoggerName();
    }

    @Override
    public LoggerContextVO getLoggerContextVO() {
        return baseEvent.getLoggerContextVO();
    }

    @Override
    public IThrowableProxy getThrowableProxy() {
        return baseEvent.getThrowableProxy();
    }

    @Override
    public StackTraceElement[] getCallerData() {
        return baseEvent.getCallerData();
    }

    @Override
    public boolean hasCallerData() {
        return baseEvent.hasCallerData();
    }

    @Override
    public Marker getMarker() {
        return baseEvent.getMarker();
    }

    @Override
    public Map<String, String> getMDCPropertyMap() {
        return baseEvent.getMDCPropertyMap();
    }

    @Override
    @Deprecated
    public Map<String, String> getMdc() {
        return baseEvent.getMdc();
    }

    @Override
    public long getTimeStamp() {
        return baseEvent.getTimeStamp();
    }

    @Override
    public void prepareForDeferredProcessing() {
        baseEvent.prepareForDeferredProcessing();
    }
}
