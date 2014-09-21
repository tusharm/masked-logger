package com.tw.examples;

import com.tw.examples.appender.masks.Introspective;
import com.tw.examples.appender.masks.objects.MaskedNonPrimitiveField;
import com.tw.examples.appender.masks.objects.Simple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMain {
    private static Logger logger = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {
        logger.debug("Main started with object [{}]", new Introspective(new MaskedNonPrimitiveField()));
    }
}
