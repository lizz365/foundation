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
    public void newThread() {
        Thread thread = new Thread(() -> {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ":googogo");
        });
        // 设置位守护线程，默认位false
        thread.setDaemon(true);
        //设置线程名称
        thread.setName("lizz-thread");
        //中断线程
        thread.interrupt();
        // 抛出异常
        thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.println("throw exception");
        });
        // 执行线程的run方法
        System.out.println("thread.run() begin");
        thread.run();
        // 启动线程
        System.out.println("thread.start() begin");
        thread.start();
        // 获取线程名称
        System.out.println("thread.getName():" + thread.getName());
        // 线程是否中断
        System.out.println("thread.isInterrupted():" + thread.isInterrupted());
        // 是否位守护线程
        System.out.println("thread.isDaemon():" + thread.isDaemon());
    }
}
