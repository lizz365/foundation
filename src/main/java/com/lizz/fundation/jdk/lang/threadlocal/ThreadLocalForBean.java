package com.lizz.fundation.jdk.lang.threadlocal;

public class ThreadLocalForBean {
    public static void main(String[] args) {
        Num num = new Num();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("thread1:seq=" + num.setAndGet(num.get() + 1) + ";code=" + num.getCode());
                    num.setCode(num.getCode()+1);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    System.out.println("thread2:seq=" + num.setAndGet(num.get() + 1) + ";code=" + num.getCode());
                    num.setCode(num.getCode()+1);
                }
            }
        }).start();
    }
}
