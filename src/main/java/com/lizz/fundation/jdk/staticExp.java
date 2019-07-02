package com.lizz.fundation.jdk;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lizz365
 */
public class staticExp {
    static int num1 = 1;
    volatile static int num2 = 0;
    static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {
        int times1=1;
        while (times1 <= 300) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    integer.incrementAndGet();
                    num1++;
                    num2++;
                }
            }).start();
            times1++;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("cas=" + integer.toString());
        System.out.println("num1=" + num1);
        System.out.println("num2=" + num2);
    }
}
