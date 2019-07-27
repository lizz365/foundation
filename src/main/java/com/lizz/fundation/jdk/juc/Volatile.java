package com.lizz.fundation.jdk.juc;

/**
 * Volatile
 *
 * @author lizz365
 * @date 19/7/17
 */
public class Volatile {
    //(1)(2)
    static volatile int num = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //(3)(4)
                num = 1;
                //(5)(6)
                System.out.println("t1 before:"+num);
                try {
                    //线程休眠1秒,等待其他线程修改参数
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //本线程的num被修改
                System.out.println("t1 after:"+num);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 before:"+num);
                num = 2;
                System.out.println("t2 after:"+num);
            }
        }).start();
//        输出:
//        t1 before:1
//        t2 before:1
//        t2 after:2
//        t1 after:2

    }
}
