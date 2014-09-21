package com.tw.examples.securelog;

import com.tw.examples.securelog.objects.SensitiveObject;
import com.tw.examples.appender.masks.objects.TestObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class SecureLoggerSpec {
    @Mock
    private Appender appender;
    @InjectMocks
    private SecureLogger logger;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldLogStringRepresentation() {
        logger.info(new TestObject());
        verify(appender).append("I am a test object");
    }

    @Test
    public void shouldMaskSensitiveObjects() {
        logger.info(new SensitiveObject());
        verify(appender).append("***");
    }

    @Test
    @Ignore
    public void shouldMaskPrimitiveTypes() {
    }


}

