package com.github.kuros.api.finder.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum BasicType {

    BOOLEAN(Boolean.class, Boolean.TYPE),
    BYTE(Byte.class, Byte.TYPE),
    CHARACTER(Character.class, Character.TYPE),
    DATE(Date.class, java.sql.Date.class),
    DOUBLE(Double.class, Double.TYPE),
    FLOAT(Float.class, Float.TYPE),
    INTEGER(Integer.class, Integer.TYPE),
    LONG(Long.class, Long.TYPE),
    SHORT(Short.class, Short.TYPE),
    STRING(String.class);

    private Class[] classes;


    BasicType(final Class<?>... classes) {
        this.classes = classes;
    }


    public static BasicType getType(final Class<?> type) {
        for (BasicType basicType : values()) {
            for (Class aClass : basicType.classes) {
                if(aClass == type){
                    return basicType;
                }
            }
        }

        return null;
    }

    public static Set<Class<?>> getBasicClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        for (BasicType basicType : values()) {
            for (Class aClass : basicType.classes) {
                classes.add(aClass);
            }
        }

        return classes;
    }
}
