package com.tw.examples.appender.masks.objects;

import com.tw.examples.appender.masks.annotations.DeepMask;
import com.tw.examples.appender.masks.annotations.IgnoreInLog;

@DeepMask
public class ClassWithIgnoreAnnotations {
    @IgnoreInLog
    private int id = 2;

    @IgnoreInLog
    SimpleWithNonPrimitiveField simpleWithNonPrimitiveField;

    private String str = "foobar";

    public ClassWithIgnoreAnnotations() {
        simpleWithNonPrimitiveField = new SimpleWithNonPrimitiveField();
    }
}
