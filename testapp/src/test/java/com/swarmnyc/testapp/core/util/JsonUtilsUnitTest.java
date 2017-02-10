package com.swarmnyc.testapp.core.util;

import com.swarmnyc.core.util.JsonUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class JsonUtilsUnitTest {
    public static class JsonObject {
        public String A = "ABC";
        public String[] B = new String[]{"123", "456"};
    }

    @Test
    public void jsonTest() throws Exception {
        JsonObject a = new JsonObject();
        String json = JsonUtils.toJson(a);
        JsonObject b = JsonUtils.fromJson(json, JsonObject.class);
        assertEquals(a.A, b.A);
        assertEquals(a.B.length, b.B.length);
    }

    @Test
    public void jsonListTest() throws Exception {

        List<JsonObject> a = new ArrayList<>();
        a.add(new JsonObject());
        a.add(new JsonObject());
        a.add(new JsonObject());
        String json = JsonUtils.toJson(a);

        List<JsonObject> b = JsonUtils.fromJsonList(json, JsonObject.class);
        assertEquals(a.size(), b.size());
        assertEquals(a.get(0).A, b.get(0).A);
    }
}