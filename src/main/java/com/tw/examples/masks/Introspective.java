package com.tw.examples.masks;

import com.google.common.base.Objects;
import com.tw.examples.masks.annotations.Introspected;
import com.tw.examples.masks.annotations.Masked;

import java.lang.reflect.Field;

public class Introspective extends AbstractMask {
    Introspective(Object object) {
        super(object);
    }

    @Override
    public String value() {
        return object.getClass().isAnnotationPresent(Introspected.class)
                ? stringify()
                : object.toString();
    }

    private String stringify() {
        Objects.ToStringHelper helper = Objects.toStringHelper(object);

        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                helper.add(field.getName(), getValue(field));
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }

        return helper.toString();
    }

    private Object getValue(Field field) throws ReflectiveOperationException {
        field.setAccessible(true);

        return field.isAnnotationPresent(Masked.class)
                ? getMaskedValue(field)
                : field.get(object);
    }

    private Object getMaskedValue(Field field) throws ReflectiveOperationException {
        Masked masked = field.getAnnotation(Masked.class);
        Mask mask = masked.type().getConstructor(Object.class).newInstance(field.get(object));
        return mask.value();
    }
}
