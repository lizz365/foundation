package com.lizz.fundation.junit;

import org.junit.*;


public class AnnotationTest {
    @Before
    public void before() {
        System.out.println("@Before");
    }
    @Test
    public void test1() {
        System.out.println("@Test1");
    }
    @Ignore
    @Test
    public void testIgnore() {
        System.out.println("@Ignore");
    }
    @Test
    public void test2() {
        System.out.println("@Test2");
    }
    /*@Test(timeout = 50)
    public void testTimeout() {
        System.out.println("@Test(timeout = 50)");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(5 + 5, 10);
    }

    @Test(expected = ArithmeticException.class)
    public void testExpected() {
        System.out.println("@Test(expected = Exception.class)");
        throw new ArithmeticException();
    }*/
    @After
    public void after() {
        System.out.println("@After");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass");
    }

}
