package com.tw.examples.appender.masks;

import com.google.common.base.Objects;
import com.google.common.primitives.Primitives;
import com.tw.examples.appender.masks.annotations.DeepMask;
import com.tw.examples.appender.masks.annotations.Masked;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Deep extends AbstractMask {
    private Set<Object> maskedObjectsMap;

    public Deep(Object object) {
        super(object);
        maskedObjectsMap = new HashSet<>();
    }

    // Required by @Masked annotation processor
    public Deep(Object object, String[] args) {
        super(object, args);
    }

    @Override
    public String value() {
        // clearing the entries for a fresh cycle
        maskedObjectsMap.clear();

        return valueOf(object);
    }

    private String valueOf(Object object) {
        // if the object has already been masked, don't mask it again
        if(maskedObjectsMap.contains(object.hashCode())) {
            return "";
        }

        if(isUserDefinedObject(object.getClass())) {
            maskedObjectsMap.add(object.hashCode());
        }

        return object.getClass().isAnnotationPresent(DeepMask.class)
                ? introspect(object)
                : object.toString();
    }

    private String introspect(Object object) {
        Objects.ToStringHelper helper = Objects.toStringHelper(object);

        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                helper.add(field.getName(), getValue(field, object));
            } catch (ReflectiveOperationException e) {}
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

    private boolean isUserDefinedObject(Class clazz) {
        return (!clazz.isPrimitive() && !clazz.equals(String.class) && !Primitives.isWrapperType(clazz));
    }
}
