package com.lizz.fundation.jdk.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

@Slf4j
public class AnnotationProcessorTest {
    @TestMethod(description = "This is a test method", priority = 2)
    public void testMethod() {
        // 测试方法的逻辑
        log.info("testMethod ok");
    }

    @Test
    public void annTest() throws NoSuchMethodException {
        // 假设我们有一个包含 @TestMethod 注解的类 MyClass
        Class<AnnotationProcessorTest> clazz = AnnotationProcessorTest.class;
        Method method = clazz.getMethod("testMethod");
        if (method.isAnnotationPresent(TestMethod.class)) {
            TestMethod testMethod = method.getAnnotation(TestMethod.class);
            String description = testMethod.description();
            int priority = testMethod.priority();
            System.out.println("Description: " + description);
            System.out.println("Priority: " + priority);
        }else{
            log.info("isNotAnnotationPresent");
        }
        AnnotationProcessor.processAnnotations(clazz);
    }
}