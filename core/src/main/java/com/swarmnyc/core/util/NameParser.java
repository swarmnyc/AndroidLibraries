package com.swarmnyc.core.util;

import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Name parser parses object get name.
 * If it has @AliasName, The method will use it.
 * Or you can add rules by regular expression, defaults are
 * (.+)Activity, $1
 * (.+)Fragment, $1
 * So if the end of class name has Activity or Fragment, The method will remove them.
 * <p>
 * If the obj doesn't has @AliasName and doesn't in the rules, the method will return class name.
 */
public class NameParser {
    private static Map<String, Couple<Pattern, String>> rules = new Hashtable<>();

    static {
        rules.put("Activity", new Couple<>(Pattern.compile("(.+)Activity"), "$1"));
        rules.put("Fragment", new Couple<>(Pattern.compile("(.+)Fragment"), "$1"));
    }

    private NameParser() {
    }

    /**
     * Add rule.
     *
     * @param key     the key
     * @param pattern the pattern
     * @param replace the replace
     */
    public static void addRule(String key, String pattern, String replace) {
        rules.put(key, new Couple<>(Pattern.compile(pattern), replace));
    }

    /**
     * Remove rule.
     *
     * @param key the key
     */
    public static void removeRule(String key) {
        rules.remove(key);
    }

    /**
     * Parse the name of obj.
     *
     * @param obj the object.
     * @return the name in string.
     */
    public static String parse(Object obj) {
        Class screenClass = obj.getClass();

        AliasName screenClassAnnotation = (AliasName) screenClass.getAnnotation(AliasName.class);
        if (screenClassAnnotation != null) {
            return screenClassAnnotation.value();
        }

        String className = screenClass.getSimpleName();

        for (Couple<Pattern, String> rule : rules.values()) {
            Matcher matcher = rule.first.matcher(className);
            if (matcher.find()){
                return matcher.replaceAll(rule.second);
            }
        }

        return className;
    }
}
