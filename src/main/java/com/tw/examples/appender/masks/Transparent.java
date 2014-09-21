package com.tw.examples.appender.masks;

public class Transparent extends AbstractMask {
    public Transparent(Object object) {
        super(object);
    }

    // Required by @Masked annotation processor
    public Transparent(Object object, String[] args) {
        super(object, args);
    }

    @Override
    public String value() {
        return object.toString();
    }
}
