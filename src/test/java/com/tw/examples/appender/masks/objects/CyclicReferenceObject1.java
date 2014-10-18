package com.tw.examples.appender.masks.objects;

import com.tw.examples.appender.masks.ShowSuffix;
import com.tw.examples.appender.masks.annotations.DeepMask;
import com.tw.examples.appender.masks.annotations.Masked;

@DeepMask
public class CyclicReferenceObject1
{
    public Integer intValue = new Integer(1);

    @Masked(type = ShowSuffix.class, args="3")
    public String strValue = "Foo!";

    public CyclicReferenceObject2 cyclicReferenceObject2;
}
