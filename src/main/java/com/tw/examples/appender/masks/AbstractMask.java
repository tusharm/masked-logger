package com.tw.examples.appender.masks;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class AbstractMask implements Mask {
    protected Object object;
    protected String[] args = new String[0];

    AbstractMask(Object object) {
        this.object = checkNotNull(object);
    }

    // Required by @Masked annotation processor
    AbstractMask(Object object, String[] args) {
        this(object);
        this.args = checkNotNull(args);
    }
}
