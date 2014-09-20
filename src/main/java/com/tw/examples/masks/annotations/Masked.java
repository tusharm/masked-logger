package com.tw.examples.masks.annotations;

import com.tw.examples.masks.HideAll;
import com.tw.examples.masks.Mask;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Masked {
    Class<? extends Mask> type() default HideAll.class;
}
