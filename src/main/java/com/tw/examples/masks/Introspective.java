package com.tw.examples.masks;

import com.google.common.base.Objects;
import com.tw.examples.masks.annotations.Introspected;
import com.tw.examples.masks.annotations.Masked;

import java.lang.reflect.Field;

public class Introspective extends AbstractMask {
    public Introspective(Object object) {
        super(object);
    }

    // Required by @Masked annotation processor
    public Introspective(Object object, String[] args) {
        super(object, args);
    }

    @Override
    public String value() {
        return valueOf(object);
    }

    private String valueOf(Object object) {
        return object.getClass().isAnnotationPresent(Introspected.class)
                ? introspect(object)
                : object.toString();
    }

    private String introspect(Object object) {
        Objects.ToStringHelper helper = Objects.toStringHelper(object);

        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                helper.add(field.getName(), getValue(field, object));
            } catch (ReflectiveOperationException e) {
                // TODO: Needs to be removed
                e.printStackTrace();
            }
        }

        return helper.toString();
    }

    private Object getValue(Field field, Object object) throws ReflectiveOperationException {
        field.setAccessible(true);

        return field.isAnnotationPresent(Masked.class)
                ? getMaskedValue(field, object)
                : valueOf(field.get(object));
    }

    private Object getMaskedValue(Field field, Object object) throws ReflectiveOperationException {
        Object value = valueOf(field.get(object));

        Masked masked = field.getAnnotation(Masked.class);
        String[] args = masked.args();
        AbstractMask mask = masked.type().getConstructor(Object.class, String[].class).newInstance(value, args);
        return mask.value();
    }
}
