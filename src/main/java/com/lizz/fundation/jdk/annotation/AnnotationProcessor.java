package com.lizz.fundation.jdk.annotation;


/**
 * @description: todo
 * @author: lizz
 * @date: 2023/8/2 15:29
 */
public class AnnotationProcessor {
    public static void processAnnotations(Class<?> clazz) {
        if (clazz.isAnnotationPresent(TestMethod.class)) {
            TestMethod testMethod = clazz.getAnnotation(TestMethod.class);
            String description = testMethod.description();
            int priority = testMethod.priority();
            System.out.println("Description: " + description);
            System.out.println("Priority: " + priority);
        }
    }
}
