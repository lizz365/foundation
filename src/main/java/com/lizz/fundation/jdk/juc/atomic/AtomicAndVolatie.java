package com.lizz.fundation.jdk.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * BaseAtomic
 *
 * @author lizz365
 * @date 19/7/22
 */
public class AtomicAndVolatie {
    /**
     * 初始化原子整数类型对象
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    /**
     * 普通线程整数变量
     */
    private static volatile int num;

    static {
        num = 0;
    }

    public static void main(String[] args) {
        //并发个数
        int count = 0;
        //线程并发次数
        int max = 1000;
        while (count < max) {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicInteger.getAndIncrement();
            }).start();
            count++;
        }
        count = 0;
        while (count < max) {
            new Thread(() -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num++;
            }).start();
            count++;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AtomicInteger num=" + atomicInteger.get());
        System.out.println("volatile num=" + num);

//        输出:
//        AtomicInteger num=1000
//        volatile num=993
    }
}
