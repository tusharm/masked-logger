package com.tw.examples.masks;

import com.tw.examples.masks.annotations.Introspected;
import com.tw.examples.masks.annotations.Masked;
import com.tw.examples.masks.objects.TestObject;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Theories.class)
public class IntrospectiveTest {
    @DataPoints
    public static Object[][] data = new Object[][] {
            {new TestObject(), "I am a test object"},
            {new Simple(), "Simple{id=12, balance=12.5, name=some-name, secured=true}"},
            {new SimpleWithNonPrimitiveField(), "SimpleWithNonPrimitiveField{text=hello, simple=Simple{id=12, balance=12.5, name=some-name, secured=true}}"},
            {new MaskedPrimitiveField(), "MaskedPrimitiveField{balance=**********, id=2}"}
    };

    @Theory
    public void shouldReturnMaskedValue(Object[] data) {
        Introspective mask = new Introspective(data[0]);
        assertThat(mask.value(), is(data[1]));
    }
}

@Introspected
class Simple {
    private int id = 12;
    Double balance = 12.50;
    public String name = "some-name";
    protected boolean secured = true;
}

@Introspected
class SimpleWithNonPrimitiveField {
    private String text = "hello";
    private Simple simple = new Simple();
}

@Introspected
class MaskedPrimitiveField {
    @Masked
    private double balance = 1000000.55;
    private int id = 2;
}


