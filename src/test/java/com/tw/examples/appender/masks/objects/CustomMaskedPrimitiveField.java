package com.tw.examples.appender.masks.objects;

import com.tw.examples.appender.masks.ShowSuffix;
import com.tw.examples.appender.masks.annotations.DeepMask;
import com.tw.examples.appender.masks.annotations.Masked;

@DeepMask
public class CustomMaskedPrimitiveField {
    @Masked(type = ShowSuffix.class, args = "4")
    private String name = "blahblahblah";
}
