package com.swarmnyc.testapp.test;

import com.swarmnyc.test.ReflectUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReflectUtilsUnitTest {
    public class TestClass {
        private String A = "ABC";
    }

    @Test
    public void getFieldValueTest() throws Exception {
        Object obj = new TestClass();
        assertEquals("ABC", ReflectUtils.getFieldValue(obj, "A"));
    }
}