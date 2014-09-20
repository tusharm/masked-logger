package com.tw.examples.masks;

public class Transparent extends AbstractMask {
    public Transparent(Object object) {
        super(object);
    }

    @Override
    public String value() {
        return object.toString();
    }
}
