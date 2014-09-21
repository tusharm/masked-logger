package com.tw.examples.appender.masks;

import com.tw.examples.appender.masks.objects.TestObject;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShowSuffixTest {
    @Test
    public void shouldShowSuffixOfGivenLength() {
        ShowSuffix mask = new ShowSuffix(new TestObject(), 6);
        assertThat(mask.value(), is("************object"));
    }
}