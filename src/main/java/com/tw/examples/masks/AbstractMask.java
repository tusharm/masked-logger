package com.tw.examples.masks;

import static java.util.Objects.requireNonNull;

public abstract class AbstractMask implements Mask {
    protected Object object;

    AbstractMask(Object object) {
        this.object = requireNonNull(object);
    }
}
