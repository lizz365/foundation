package com.lizz.fundation.jdk.juc.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * Stamped
 *
 * @author lizz365
 * @date 19/7/23
 */
public class Stamped {
    /**
     * 标记锁
     * 每个锁都会生成一个标记,解锁时需要传入对于的所标记
     */
    static StampedLock stampedLock = new StampedLock();
    static volatile long stamp;
    public static void main(String[] args) {

//        stampedLock.asReadLock();
//        stampedLock.asReadWriteLock();
//        stampedLock.asWriteLock();
//        stampedLock.getReadLockCount();
//        stampedLock.isReadLocked();
//        stampedLock.isWriteLocked();
        //读锁
        //可进行
        stampedLock.readLock();

//
//        stampedLock.readLockInterruptibly();
//        stampedLock.tryConvertToOptimisticRead();
//        stampedLock.tryConvertToReadLock();
//        stampedLock.tryOptimisticRead();
//        stampedLock.tryConvertToWriteLock();
//        stampedLock.tryReadLock();
//        stampedLock.tryReadLock();
//        stampedLock.tryUnlockRead();
//        stampedLock.tryUnlockWrite();
//        stampedLock.unlock();
//        stampedLock.unlockRead();
//        stampedLock.unlockWrite();
//        stampedLock.validate();
//        stampedLock.writeLock();
//        stampedLock.writeLockInterruptibly();





        new Thread(){
            @Override
            public void run() {
                System.out.println("t1 is lock");
                int num = 0;
                stamp =  stampedLock.writeLock();
                num++;
                System.out.println("t1 is runing");
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stampedLock.unlockWrite(stamp);
                System.out.println("t1 lock unlockWrite:"+stamp);
            }
        }.start();
    }
}
