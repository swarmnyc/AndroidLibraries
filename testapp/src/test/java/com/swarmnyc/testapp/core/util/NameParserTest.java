package com.swarmnyc.testapp.core.util;

import com.swarmnyc.core.util.AliasName;
import com.swarmnyc.core.util.NameParser;
import com.swarmnyc.testapp.MainActivity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameParserTest {

    @AliasName("Good")
    public static class TestActivity{

    }

    @Test
    public void parserTest() throws Exception {
        assertEquals("Main", NameParser.parse(new MainActivity()));
        assertEquals("Main", NameParser.parse(new MainActivity()));
        assertEquals("Good", NameParser.parse(new TestActivity()));
    }
}
