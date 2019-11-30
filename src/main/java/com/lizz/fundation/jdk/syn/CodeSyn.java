package com.lizz.fundation.jdk.syn;

/**
 * this 当对象代码块锁
 * object.class 类锁
 * @author lizz365
 */
public class CodeSyn {
    public void m1(String arg) {
        System.out.println(arg +" begin");
        try {
            synchronized (this) {
                System.out.println(arg + " this excute " +System.currentTimeMillis() );
                Thread.sleep(3000);
            }
            synchronized (CodeSyn.class) {
                System.out.println(arg + " class excute " +System.currentTimeMillis() );
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arg+" end");
    }

    public static void main(String[] args) {
        final CodeSyn m1 = new CodeSyn();
        final CodeSyn m2 = new CodeSyn();

        new Thread(new Runnable() {
            @Override
            public void run() {
                m1.m1("a");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                m1.m1("b");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                m2.m1("c");
            }
        }).start();
    }
}
