package com.tw.examples.appender.masks;

import static org.apache.commons.lang.StringUtils.repeat;

public class HideAll extends AbstractMask {
    public HideAll(Object object) {
        super(object);
    }

    // Required by @Masked annotation processor
    public HideAll(Object object, String[] args) {
        super(object, args);
    }

    @Override
    public String value() {
        return repeat("*", object.toString().length());
    }
}
