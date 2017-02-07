package com.swarmnyc.test;

import java.lang.reflect.Field;

public class ReflectUtils {
    public static Object getFieldValue(Object source, String field) throws Exception {
        Class c = source.getClass();
        Field f = c.getDeclaredField(field);
        f.setAccessible(true);
        return f.get(source);
    }
}
