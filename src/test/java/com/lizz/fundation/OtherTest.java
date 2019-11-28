package com.lizz.fundation;

import org.junit.Test;

public class OtherTest {

    @Test
    public  void aaa() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (true) {
                    //true
                    System.out.println("线程是否被打断:" +i+"@" + Thread.currentThread().isInterrupted());
                    //true
                    System.out.println("线程确认是否被打断:" +i+"@"+ Thread.currentThread().isInterrupted());

                    //判断是否被中断
                    if(Thread.interrupted()){
                        System.out.println("线程被中断"+i+"@");

                        //此时返回 false
                        System.out.println("Thread.interupted():"+i+"@"+Thread.interrupted());
                        break;
                    }
                    i++;
                }
            }
        }).start();
    }
}

