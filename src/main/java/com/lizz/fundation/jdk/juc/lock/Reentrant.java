package com.lizz.fundation.jdk.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrant
 * 重入锁
 * @author lizz365
 * @date 19/7/23
 */
public class Reentrant {
    /**
     * 创建锁公平锁
     * 无参默认为true
     *
     * lock()获取锁时直接放入同步队列末尾等待.
     */
    static ReentrantLock fairLock = new ReentrantLock();
//    static fairLock fairLock = new fairLock(true);
    /**
     * 非公平锁
     * lock()获取锁时先尝试获取锁,失败后插入队列末尾等待.
     *
     */
    static ReentrantLock notFairLock = new ReentrantLock(false);

    public static void main(String[] args) {

        //尝试获取锁
        boolean lockOk = fairLock.tryLock();
        //一定时间内尝试获取锁
        try {
            boolean timeLockOk = fairLock.tryLock(1000L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取锁
        fairLock.lock();
        //获取可中断锁
        try {
            fairLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fairLock.getHoldCount();
        fairLock.getQueueLength();

        //判断线程是否在等待队列中
        fairLock.hasQueuedThread(Thread.currentThread());
        //判断是等待队列是否存在多个等待队列
        //是则返回true
        //只有一个则返回false
        fairLock.hasQueuedThreads();
        //是否公平锁
        fairLock.isFair();
        //当前线程是否有锁,ture-有,false-没有.
        fairLock.isHeldByCurrentThread();
        //是否有锁状态
        fairLock.isLocked();
        //构建条件对象,控制锁状态
        Condition lockCondition = fairLock.newCondition();
        //根据构建条件,检查当前是否存在线程使用了Condition.await方法,并处在await状态中
        fairLock.hasWaiters(lockCondition);
        //获取给定条件的线程数
        //注意:因为线程状态变化较快,返回值作为参考值
        fairLock.getWaitQueueLength(lockCondition);
        //释放锁
        fairLock.unlock();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
