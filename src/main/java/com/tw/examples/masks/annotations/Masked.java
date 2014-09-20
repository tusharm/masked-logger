package com.tw.examples.masks.annotations;

import com.tw.examples.masks.AbstractMask;
import com.tw.examples.masks.HideAll;
import com.tw.examples.masks.Mask;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Masked {
    Class<? extends AbstractMask> type() default HideAll.class;
    String[] args() default {};
}
