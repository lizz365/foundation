package com.lizz.fundation.jdk.juc.thread;

import java.util.concurrent.*;

/**
 * ThreadExecutor
 *
 * @author lizz365
 * @date 19/7/24
 */
public class ThreadExecutor {

    /**
     * 线程池
     */
    static ExecutorService executorService;

    public static void main(String[] args) {
        //核心线程数,线程池中最小线程数
        int corePoolSize = 4;
        //线程池中允许的最大线程数;
        int maximumPoolSize=2000;
        //核心线程外的空闲线程存活时间
        long keepAliveTime = 60;
        //线程存活时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        //线程队列类型
        //ArrayBlockingQueue(int num):数组队列
        //FIFO

        //ConcurrentLinkedDeque:
        //ConcurrentLinkedQueue:

        //DelayQueue:延时队列
        //到期后执行

        //LinkedBlockingDeque:定长链表堵塞队列
        //

        //LinkedBlockingQueue:定长链表堵塞队列
        //LinkedTransferQueue:不定长链表堵塞队列
        //PriorityBlockingQueue:可排序优先级无界堵塞队列
        //SynchronousQueue:同步队列,双队列模式
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
        //自定义线程工厂,如线程组,线程名称,线程参数,线程堆栈大小.不传则使用默认工厂设置
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //拒绝策略,线程数超出最大线程数时对新线程的处理方法
        //ThreadPoolExecutor.AbortPolicy():默认抛出RejectedExecutionException异常
        //ThreadPoolExecutor.CallerRunsPolicy():当前线程直接执行.
        //ThreadPoolExecutor.DiscardPolicy():直接抛弃任务,不做处理.
        //ThreadPoolExecutor.DiscadOldestPolicy():抛弃任务队列中头部任务,将让位插入队列末尾.
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy() ;
        executorService = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);


        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool();
//        Executors.newScheduledThreadPool();
        Executors.newSingleThreadExecutor();
        Callable callable  = Executors.callable(new Runnable() {
            @Override
            public void run() {

            }
        });
        Callable callable1  =  Executors.privilegedCallable(callable);
    }
}
