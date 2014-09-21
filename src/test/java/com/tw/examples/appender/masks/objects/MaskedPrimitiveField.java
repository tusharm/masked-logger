package com.tw.examples.appender.masks.objects;

import com.tw.examples.appender.masks.annotations.Introspected;
import com.tw.examples.appender.masks.annotations.Masked;

@Introspected
public class MaskedPrimitiveField {
    @Masked
    private double balance = 1000000.55;
    private int id = 2;
}
