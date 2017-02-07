package com.swarmnyc.core.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().create();
        }

        return gson;
    }

    public static String toJson(Object o) {
        return getGson().toJson(o);
    }

    public static <T> T fromJson(String json, Class<T> type) {
        return getGson().fromJson(json, type);
    }

    public static <T> List<T> fromJsonList(String json, final Class<T> type) {
        return getGson().fromJson(json, new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{type};
            }

            @Override
            public Type getRawType() {
                return ArrayList.class;
            }

            @Override
            public Type getOwnerType() {
                return ArrayList.class;
            }
        });
    }

}
