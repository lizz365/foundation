package com.lizz.fundation.jdk.future;

import java.util.concurrent.*;

/**
 * @description: todo
 * @author: lizz
 * @date: 2020/8/15 17:26
 */
public class FutureSample {
    ExecutorService executor = Executors.newCachedThreadPool();
    //向ExecutorService提交一个Callable对象
    Future<String> future = executor.submit(new Callable<String>() {
        @Override
        public String call() {
            return "Hello World！";//以异步方式在新线程中执行耗时的操作
        }
    });
    String result;//获取异步操作结果，如果被阻塞，无法得到结果，在等待1秒钟后退出
    {
        try {
            result = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
