package com.tw.examples.masks;

import static org.apache.commons.lang.StringUtils.repeat;

public class ShowSuffix extends AbstractMask {
    private int suffixLength;

    public ShowSuffix(Object object, int suffixLength) {
        super(object);
        this.suffixLength = suffixLength;
    }

    @Override
    public String value() {
        String string = object.toString();
        int prefixLength = string.length() - suffixLength;

        return repeat("*", prefixLength) + string.substring(prefixLength);
    }
}
