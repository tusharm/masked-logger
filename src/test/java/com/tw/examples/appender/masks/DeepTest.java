package com.tw.examples.appender.masks;

import com.tw.examples.appender.masks.objects.*;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.internal.util.Primitives;

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

    @Test
    public void shouldNotLoopInfinitelyForCyclicReferences() {
        CyclicReferenceObject1 cyclicReferenceObject1 = new CyclicReferenceObject1();
        CyclicReferenceObject2 cyclicReferenceObject2 = new CyclicReferenceObject2();
        cyclicReferenceObject1.cyclicReferenceObject2 = cyclicReferenceObject2;
        cyclicReferenceObject2.cyclicReferenceObject1 = cyclicReferenceObject1;
        String expectedMaskedValue = "CyclicReferenceObject1{intValue=1, strValue=*oo!, cyclicReferenceObject2=CyclicReferenceObject2{intValue=1, strValue=*oo!, cyclicReferenceObject1=}}";

        Deep mask = new Deep(cyclicReferenceObject1);

        assertThat(mask.value(), is(expectedMaskedValue));
    }

    @Test
    public void shouldNotLogFieldsWithIgnoreAnnotation() {
        ClassWithIgnoreAnnotations classWithIgnoreAnnotations = new ClassWithIgnoreAnnotations();
        String expectedMaskedValue = "ClassWithIgnoreAnnotations{str=foobar}";

        Deep mask = new Deep(classWithIgnoreAnnotations);

        assertThat(mask.value(), is(expectedMaskedValue));
    }
}




