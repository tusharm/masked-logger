package com.tw.examples.appender.masks.objects;

import com.tw.examples.appender.masks.ShowSuffix;
import com.tw.examples.appender.masks.annotations.Introspected;
import com.tw.examples.appender.masks.annotations.Masked;

@Introspected
public class CustomMaskedPrimitiveField {
    @Masked(type = ShowSuffix.class, args = "4")
    private String name = "blahblahblah";
}
