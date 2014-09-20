package com.tw.examples.masks;

import static org.apache.commons.lang.StringUtils.repeat;

public class HideAll extends AbstractMask {
    public HideAll(Object object) {
        super(object);
    }

    @Override
    public String value() {
        return repeat("*", object.toString().length());
    }
}
