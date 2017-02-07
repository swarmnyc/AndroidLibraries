package com.swarmnyc.testapp.core.util;

import com.swarmnyc.core.util.JsonUtils;
import com.swarmnyc.core.util.StringUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
}