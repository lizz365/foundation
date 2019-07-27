package com.lizz.fundation.jdk;

/**
 * ThreadExp
 *
 * @author lizz365
 * @date 19/7/25
 */
public class ThreadExp {

    public static void main(String[] args) {

//          ThreadGroup group, 线程组
//          Runnable target 执行器
//          String name,    线程名称
//          long stackSize 线程堆栈大小

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        });
        thread.start();
//        thread.join();
//        thread.getId();
//        thread.
    }

}
