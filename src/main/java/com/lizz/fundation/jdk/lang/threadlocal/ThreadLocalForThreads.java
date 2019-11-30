package com.lizz.fundation.jdk.lang.threadlocal;

/**
 * @author lizz365
 */
public class ThreadLocalForThreads {
    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        ThreadLocalForThreads sn = new ThreadLocalForThreads();
        // ③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient();
        TestClient t2 = new TestClient();
        TestClient t3 = new TestClient();
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++) {
                seqNum.set(seqNum.get() + 1);
                // ④每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                        + seqNum.get() + "]");
            }
        }
    }
}
