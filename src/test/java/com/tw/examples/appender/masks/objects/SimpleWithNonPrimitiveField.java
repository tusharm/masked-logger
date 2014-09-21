package com.tw.examples.appender.masks.objects;

import com.tw.examples.appender.masks.annotations.Introspected;

@Introspected
public class SimpleWithNonPrimitiveField {
    private String text = "hello";
    private Simple simple = new Simple();
}
