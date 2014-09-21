package com.tw.examples.appender.masks;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Integer.parseInt;
import static org.apache.commons.lang.StringUtils.repeat;

public class ShowSuffix extends AbstractMask {
    private int suffixLength;

    public ShowSuffix(Object object, int suffixLength) {
        super(object);
        this.suffixLength = suffixLength;
    }

    // Required by @Masked annotation processor
    public ShowSuffix(Object object, String[] args) {
        super(object, args);

        checkArgument(args.length >= 1);
        this.suffixLength = parseInt(args[0]);
    }

    @Override
    public String value() {
        String string = object.toString();
        int prefixLength = string.length() - suffixLength;

        return repeat("*", prefixLength) + string.substring(prefixLength);
    }
}
