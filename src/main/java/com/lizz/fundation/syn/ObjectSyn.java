package com.lizz.fundation.syn;

/**
 * 对象锁，锁住实例化对象中所有synchronized方法
 * @author lizz365
 */
public class ObjectSyn {
    private static int  num;
    public synchronized void m1(String tag) {
        System.out.println(tag+" over");
        if("a".equals(tag)){
            num = 100;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            num = 200;
        }
        System.out.println( tag + " = "+ num);
    }


    public static void main(String[] args) {
        final ObjectSyn test = new ObjectSyn();
        final ObjectSyn test1 = new ObjectSyn();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.m1("a");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.m1("b");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.m1("c");
            }
        }).start();
    }
}
