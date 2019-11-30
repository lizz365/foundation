package com.lizz.fundation.jdk.syn;

/**
 * 类锁
 * 方法前增加 static修饰符，不同实例化对象都必须拿到
 *
 * @author lizz365
 */
public class ClassSyn {
    private static int num;

    public static synchronized void method01(String arg) {
        try {
            if ("a".equals(arg)) {
                num = 100;
                System.out.println("a over");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("b over");
            }
            System.out.println(arg + " = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  synchronized void method02(String arg) {
        System.out.println(arg + " = " + num);
    }

    public static void main(String[] args) {
        final ClassSyn m1 = new ClassSyn();
        final ClassSyn m2 = new ClassSyn();

        new Thread(new Runnable() {

            @Override
            public void run() {
                m1.method01("a");
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                m2.method01("b");
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                m2.method02("c");
            }
        }).start();


    }
}
