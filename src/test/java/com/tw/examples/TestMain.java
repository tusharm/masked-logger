package com.tw.examples;

import com.tw.examples.appender.masks.objects.MaskedNonPrimitiveField;
import com.tw.examples.appender.masks.objects.MaskedPrimitiveField;
import com.tw.examples.appender.masks.objects.SimpleWithNonPrimitiveField;
import com.tw.examples.appender.masks.objects.TestObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tw.examples.appender.masks.Masks.*;

public class TestMain {
    private static Logger logger = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {
        logger.debug("Logging with no mask - {}", none(new TestObject()));
        logger.debug("Logging with all masked - {}", all(new SimpleWithNonPrimitiveField()));
        logger.debug("Logging with prefix masked - {}", showSuffix("24214535624756735", 4));
        logger.debug("Logging with deep reflective mask - {}", deep(new MaskedNonPrimitiveField()));
    }
}
