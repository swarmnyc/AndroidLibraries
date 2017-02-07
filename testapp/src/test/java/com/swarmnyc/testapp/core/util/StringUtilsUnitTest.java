package com.swarmnyc.testapp.core.util;

import com.swarmnyc.core.util.JsonUtils;
import com.swarmnyc.core.util.StringUtils;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StringUtilsUnitTest {

    @Test
    public void emptyTest() throws Exception {
        assertTrue(StringUtils.isEmpty(""));
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty("   "));
        assertTrue(StringUtils.isNotEmpty("ABC"));
        assertTrue(StringUtils.isNotEmpty("  ABC "));
        assertTrue(StringUtils.isEmpty((CharSequence)""));
        assertTrue(StringUtils.isNotEmpty((CharSequence)"  "));
    }

    @Test
    public void paddingTest() throws Exception {
        assertEquals("    1", StringUtils.leftPad("1", 5));
        assertEquals("   12", StringUtils.leftPad("12", 5));
        assertEquals("00012", StringUtils.leftPad("12", 5, '0'));
        assertEquals("AAA12", StringUtils.leftPad("12", 5, "AA"));
    }

    @Test
    public void capitalizeTest() throws Exception {
        assertEquals("1", StringUtils.capitalize("1"));
        assertEquals("Wade", StringUtils.capitalize("wade"));
        assertEquals("Wade", StringUtils.capitalize("Wade"));
    }

    @Test
    public void areEqualTest() throws Exception {
        assertTrue(StringUtils.areEqual("1", "1"));
        assertTrue(StringUtils.areEqual("ABC", "ABC"));
        assertFalse(StringUtils.areEqual("ABC", "1"));
    }

    @Test
    public void compareNumberTest() throws Exception {
        assertEquals(0, StringUtils.compareNumber("1", "1"));
        assertEquals(-1, StringUtils.compareNumber("1", "2"));
        assertEquals(1, StringUtils.compareNumber("2", "1"));
    }
}