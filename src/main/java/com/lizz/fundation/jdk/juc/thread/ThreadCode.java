package com.lizz.fundation.jdk.juc.thread;

import org.junit.Test;

/**
 * @ClassName ThreadCode
 * @Description: 线程源码
 * @Author lizz365
 * @Date 2019/12/1
 **/
public class ThreadCode {
    @Test
    public void newThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("googogo");
            }
        });
    }
}
