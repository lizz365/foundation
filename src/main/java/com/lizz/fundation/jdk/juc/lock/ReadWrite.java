package com.lizz.fundation.jdk.juc.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWrite
 *
 * @author lizz365
 * @date 19/7/24
 */
public class ReadWrite {
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static long now = System.currentTimeMillis();

    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();
        new Thread(){
            @Override
            public void run() {
                System.out.println("getAge1 user1:"+user1.getAge()+":"+(System.currentTimeMillis()-now));
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("getAge2 user1:"+user1.getAge()+":"+(System.currentTimeMillis()-now));
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                user1.setAge(10);
                System.out.println("setAge1 user1:"+user1.getAge()+":"+(System.currentTimeMillis()-now));
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                user1.setAge(20);
                System.out.println("setAge2 user1:"+user1.getAge()+":"+(System.currentTimeMillis()-now));
            }
        }.start();




        new Thread(){
            @Override
            public void run() {
                user2.setAge(10);
                System.out.println("setAge1 user2:"+user2.getAge()+":"+(System.currentTimeMillis()-now));
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("getAge1 user2:"+user2.getAge()+":"+(System.currentTimeMillis()-now));
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                user2.setAge(20);
                System.out.println("setAge2 user2:"+user2.getAge()+":"+(System.currentTimeMillis()-now));
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("getAge2 user2:"+user2.getAge()+":"+(System.currentTimeMillis()-now));
            }
        }.start();

//        //获取写锁
//        //lock后无法再进行读/写锁,readLock.lock()和writeLock.lock()
//        readWriteLock.writeLock();
//        //获取读锁
//        //lock后无法进行写锁writeLock.lock(),可以进行读锁readLock.lock()
//        readWriteLock.readLock();
//
//        //获取锁
//        //其他方法与Lock一致
//        readWriteLock.writeLock().lock();
//        readWriteLock.readLock().lock();

    }



    public static class User{
        int age;

        public int getAge() {
            readWriteLock.readLock().lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readWriteLock.readLock().unlock();
            return age;

        }

        public void setAge(int age)  {
            readWriteLock.writeLock().lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.age = age;
            readWriteLock.writeLock().unlock();
        }
    }

}
