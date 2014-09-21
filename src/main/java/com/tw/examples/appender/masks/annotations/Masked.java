package com.tw.examples.appender.masks.annotations;

import com.tw.examples.appender.masks.AbstractMask;
import com.tw.examples.appender.masks.HideAll;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Masked {
    Class<? extends AbstractMask> type() default HideAll.class;
    String[] args() default {};
}
