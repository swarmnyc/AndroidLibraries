package com.swarmnyc.testapp.core.utils;

import com.swarmnyc.core.utils.DateUtil;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateUtilUnitTest {
    @Test
    public void isoFormatTest() throws Exception {
        assertEquals("1984-03-01T11:11:11", DateUtil.isoFormat(new Date(1984-1900, 3-1, 1, 11, 11, 11)));
    }

    @Test
    public void fileFormatTest() throws Exception {
        assertEquals("1984-03-01-11-11-11", DateUtil.fileFormat(new Date(1984-1900, 3-1, 1, 11, 11, 11)));
    }
}