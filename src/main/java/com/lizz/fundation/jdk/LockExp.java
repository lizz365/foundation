package com.lizz.fundation.jdk;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author lizz365
 */
public class LockExp {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    /*
    获取锁标记
     */
    static StampedLock stampedLock = new StampedLock();

    public static void main(String[] args) {
        long stamp = stampedLock.writeLock();
        try {
            System.out.println("stamp1=" + stamp);
        } finally{
            stampedLock.unlockWrite(stamp);
        }
        stamp = stampedLock.writeLock();
        try {
            System.out.println("stamp2=" + stamp);
        } finally{
            stampedLock.unlockWrite(stamp);
        }
    }
}
