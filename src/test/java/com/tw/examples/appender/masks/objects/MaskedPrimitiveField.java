package com.tw.examples.appender.masks.objects;

import com.tw.examples.appender.masks.ShowSuffix;
import com.tw.examples.appender.masks.annotations.DeepMask;
import com.tw.examples.appender.masks.annotations.Masked;

@DeepMask
public class MaskedPrimitiveField {
    @Masked(type = ShowSuffix.class, args = "3")
    private double balance = 1000000.55;
    private int id = 2;
}
