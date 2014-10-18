package com.tw.examples.appender;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MaskingAppenderTest {

    private ch.qos.logback.classic.Logger logger;
    private MaskingAppender maskingAppender;
    private Appender<ILoggingEvent> mockAppender;

    @Before
    public void beforeEach() throws IOException {
        mockAppender = mock(Appender.class);

        logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.setLevel(Level.ALL);

        maskingAppender = (MaskingAppender) logger.getAppender("MASK");
        maskingAppender.detachAndStopAllAppenders();
        maskingAppender.addAppender(mockAppender);
        maskingAppender.start();
    }

    @Test
    public void shouldCreateMaskedEvent() throws IOException {
        logger.debug("some message");

        ArgumentCaptor<MaskedEvent> captor = ArgumentCaptor.forClass(MaskedEvent.class);
        verify(mockAppender).doAppend(captor.capture());

        MaskedEvent event = captor.getValue();
        assertThat(event.getMessage(), is("some message"));
    }
}