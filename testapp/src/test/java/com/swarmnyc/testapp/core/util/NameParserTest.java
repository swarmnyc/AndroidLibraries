package com.swarmnyc.testapp.core.util;

import com.swarmnyc.core.util.AliasName;
import com.swarmnyc.core.util.NameParser;
import com.swarmnyc.testapp.MainActivity;
import com.swarmnyc.testapp.SecondActivity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameParserTest {

    @AliasName("Good")
    private static class TestActivity {

    }

    private static class One {

    }

    @Test
    public void parserTest() throws Exception {
        assertEquals("Main", NameParser.parse(new MainActivity()));
        assertEquals("Second", NameParser.parse(new SecondActivity()));
        assertEquals("Good", NameParser.parse(new TestActivity()));

        NameParser.addRule("One", "One", "Two");
        assertEquals("Two", NameParser.parse(new One()));

        NameParser.removeRule("One");
        assertEquals("One", NameParser.parse(new One()));
    }
}
