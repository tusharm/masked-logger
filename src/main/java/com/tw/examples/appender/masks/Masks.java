package com.tw.examples.appender.masks;

public class Masks {
    public static Mask all(Object object) {
        return new HideAll(object);
    }

    public static Mask showSuffix(Object object, int suffixLength) {
        return new ShowSuffix(object, suffixLength);
    }

    public static Mask none(Object object) {
        return new Transparent(object);
    }

    public static Mask deep(Object object) {
        return new Deep(object);
    }
}
