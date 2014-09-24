package com.tw.examples.appender.masks.objects;

import com.tw.examples.appender.masks.annotations.DeepMask;
import com.tw.examples.appender.masks.annotations.Masked;

@DeepMask
public class MaskedNonPrimitiveField {
    private int id = 2;

    @Masked
    private MaskedPrimitiveField field1 = new MaskedPrimitiveField();

    private MaskedPrimitiveField field2 = new MaskedPrimitiveField();
}
