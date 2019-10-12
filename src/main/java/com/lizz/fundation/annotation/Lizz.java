package com.lizz.fundation.annotation;

import java.lang.annotation.*;

/**
 * @author lizz365
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lizz {
    String name() default "lizz365";
}
