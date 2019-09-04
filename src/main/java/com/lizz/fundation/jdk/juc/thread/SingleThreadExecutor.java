package com.lizz.fundation.jdk.juc.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lizz365
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool();
//        Executors.newScheduledThreadPool();
    }
}
