package com.lizz.fundation.jdk.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/**
 * BaseAtomic
 *
 * @author lizz365
 * @date 19/7/22
 */
public class BaseAtomic {
    /**
     * 初始化为0
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        //设置当前值为1
        atomicInteger.set(1);
        //返回当前值;
        atomicInteger.get();
        //返回当前值并做原子加1;
        atomicInteger.getAndIncrement();
        //做原子加1并返回变更后的值;
        atomicInteger.incrementAndGet();
        //返回当前值并做原子加n;
        atomicInteger.getAndAdd(10);
        //做原子加n并返回变更后的值;
        atomicInteger.addAndGet(10);
        //返回当前值并做原子减1;
        atomicInteger.getAndDecrement();
        //做原子减1并返回变更后的值;
        atomicInteger.decrementAndGet();
        //设置为2,本地内存操作,不保证线程可见
        atomicInteger.lazySet(2);

        //原子性函数修改后并返回变更后的值
        IntUnaryOperator intUnaryOperator = operand -> operand + 2;
        atomicInteger.updateAndGet(intUnaryOperator);
    }
}
