package com.tw.examples.securelog.objects;

import com.tw.examples.securelog.Sensitive;

@Sensitive
public class SensitiveObject {
    @Override
    public String toString() {
        return "I am a sensitive object";
    }
}
