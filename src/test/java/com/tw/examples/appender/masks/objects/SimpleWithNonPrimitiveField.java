package com.tw.examples.appender.masks.objects;

import com.tw.examples.appender.masks.annotations.DeepMask;

@DeepMask
public class SimpleWithNonPrimitiveField {
    private String text = "hello";
    private Simple simple = new Simple();
}
