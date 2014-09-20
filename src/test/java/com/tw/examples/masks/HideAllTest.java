package com.tw.examples.masks;

import com.tw.examples.masks.objects.TestObject;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class HideAllTest {

    @DataPoints
    public static Object[][] data = new Object[][]{
            {1, "*"},
            {12L, "**"},
            {12.50, "****"},
            {true, "****"},
            {new TestObject(), "******************"}
    };

    @Theory
    public void shouldReplaceAllCharsWithAsterisks(Object[] data) {
        HideAll mask = new HideAll(data[0]);
        assertThat(mask.value(), is(data[1]));
    }
}