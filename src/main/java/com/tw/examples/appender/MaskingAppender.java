package com.tw.examples.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.spi.AppenderAttachable;
import ch.qos.logback.core.spi.AppenderAttachableImpl;

import java.util.Iterator;

public class MaskingAppender extends AppenderBase<ILoggingEvent> implements AppenderAttachable<ILoggingEvent> {
    private AppenderAttachableImpl<ILoggingEvent> appenderAttachable = new AppenderAttachableImpl<>();

    @Override
    protected void append(ILoggingEvent event) {
        appenderAttachable.appendLoopOnAppenders(new MaskedEvent(event));
    }

    @Override
    public void addAppender(Appender<ILoggingEvent> newAppender) {
        appenderAttachable.addAppender(newAppender);
    }

    @Override
    public Iterator<Appender<ILoggingEvent>> iteratorForAppenders() {
        return appenderAttachable.iteratorForAppenders();
    }

    @Override
    public Appender<ILoggingEvent> getAppender(String name) {
        return appenderAttachable.getAppender(name);
    }

    @Override
    public boolean isAttached(Appender<ILoggingEvent> appender) {
        return appenderAttachable.isAttached(appender);
    }

    @Override
    public void detachAndStopAllAppenders() {
        appenderAttachable.detachAndStopAllAppenders();
    }

    @Override
    public boolean detachAppender(Appender<ILoggingEvent> appender) {
        return appenderAttachable.detachAppender(appender);
    }

    @Override
    public boolean detachAppender(String name) {
        return appenderAttachable.detachAppender(name);
    }
}
