package com.tw.examples.securelog.objects;

import com.tw.examples.masks.annotations.Sensitive;

@Sensitive
public class SensitiveObject {
    @Override
    public String toString() {
        return "I am a sensitive object";
    }
}
