package com.swarmnyc.testapp.core.util;

import com.swarmnyc.core.util.DateTimeUtils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateTimeUtilsUnitTest {
    @Test
    public void isoFormatTest() throws Exception {
        assertEquals("1984-03-01T11:11:11", DateTimeUtils.isoFormat(new Date(1984 - 1900, 3 - 1, 1, 11, 11, 11)));
    }

    @Test
    public void fileFormatTest() throws Exception {
        assertEquals("1984-03-01-11-11-11", DateTimeUtils.fileFormat(new Date(1984 - 1900, 3 - 1, 1, 11, 11, 11)));
    }

    @Test
    public void msToStringTest() throws Exception {
        assertEquals("Less than a second", DateTimeUtils.msToString(100));
        assertEquals("1 sec", DateTimeUtils.msToString(1100));
        assertEquals("12 secs", DateTimeUtils.msToString(12100));
        assertEquals("5 mins, 12 secs", DateTimeUtils.msToString(DateTimeUtils.toMillisecond(0, 0, 5, 12)));
        assertEquals("6 hours, 1 min, 52 secs", DateTimeUtils.msToString(DateTimeUtils.toMillisecond(0, 6, 1, 52)));
        assertEquals("1 day", DateTimeUtils.msToString(DateTimeUtils.toMillisecond(0, 24, 0, 0)));
        assertEquals("1 day", DateTimeUtils.msToString(DateTimeUtils.toMillisecond(1, 0, 0, 0)));
    }
}