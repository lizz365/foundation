package com.lizz.fundation.jdk.juc.thread;

/**
 * @ClassName ThreadFunction
 * @Description: 线程方法
 * @Author lizz365
 * @Date 2019/12/1
 **/
public class ThreadFunction {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        thread.start();
        try {
            thread.join();
            thread.join(1000);
            thread.join(1000,1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.isInterrupted();
        thread.run();
        thread.toString();
        //
        thread.checkAccess();
        //中断线程
        thread.interrupt();
        //是否活跃
        thread.isAlive();
        //守护线程是否开启
        thread.isDaemon();


        thread.getName();
        thread.getId();
        thread.getContextClassLoader();
        thread.getState();
        thread.getPriority();
        thread.getStackTrace();
        thread.getThreadGroup();
        thread.getUncaughtExceptionHandler();

//        thread.setContextClassLoader();
//        thread.setDaemon();
//        thread.setName();
//        thread.setPriority();
//        thread.setUncaughtExceptionHandler();
    }
}
