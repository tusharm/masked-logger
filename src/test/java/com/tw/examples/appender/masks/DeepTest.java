package com.tw.examples.appender.masks;

import com.tw.examples.appender.masks.objects.*;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Theories.class)
public class DeepTest {
    @DataPoints
    public static Object[][] data = new Object[][] {
            {new TestObject(), "I am a test object"},
            {new Simple(), "Simple{id=12, balance=12.5, name=some-name, secured=true}"},
            {new SimpleWithNonPrimitiveField(), "SimpleWithNonPrimitiveField{text=hello, simple=Simple{id=12, balance=12.5, name=some-name, secured=true}}"},
            {new MaskedPrimitiveField(), "MaskedPrimitiveField{balance=*******.55, id=2}"},
            {new CustomMaskedPrimitiveField(), "CustomMaskedPrimitiveField{name=********blah}"},
            {new MaskedNonPrimitiveField(), "MaskedNonPrimitiveField{id=2, field1=**********************************************, field2=MaskedPrimitiveField{balance=*******.55, id=2}}"}
    };

    @Theory
    public void shouldReturnMaskedValue(Object[] data) {
        Deep mask = new Deep(data[0]);
        assertThat(mask.value(), is(data[1]));
    }
}




