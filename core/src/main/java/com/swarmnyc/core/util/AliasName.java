package com.swarmnyc.core.util;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The alias name of the type.
 * <pre>
 *    &#064;AliasName("You name it")
 *    public class MainActivity {
 *        ...
 *    }
 * </pre>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AliasName {
    String value();
}
