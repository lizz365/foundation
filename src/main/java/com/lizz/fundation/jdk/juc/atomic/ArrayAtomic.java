package com.lizz.fundation.jdk.juc.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.function.LongBinaryOperator;

/**
 * BaseAtomic
 *
 * @author lizz365
 * @date 19/7/22
 */
public class ArrayAtomic {
    /**
     * 初始化为数组长度
     */
    private static AtomicLongArray atomicLongArray = new AtomicLongArray(2);

    public static void main(String[] args) {
        //输出数组长度
        atomicLongArray.length();
        //设置数组索引0上的值为1
        atomicLongArray.set(0, 1L);
        //获取数组索引上的值
        atomicLongArray.get(0);
        //数组索引0上的值加1,并返回变更后的结果
        atomicLongArray.incrementAndGet(0);
        //返回数组索引0上的值,并在数组中的值加1
        atomicLongArray.getAndIncrement(0);
        //数组索引0上的值减1,并返回变更后的结果
        atomicLongArray.decrementAndGet(0);
        //返回数组索引0上的值,并在数组中的值减1
        atomicLongArray.getAndDecrement(0);
        //数组索引0上的值加2,并返回变更后的结果
        atomicLongArray.addAndGet(0, 2L);
        //返回数组索引0上的值,并在数组中的值加2
        atomicLongArray.getAndAdd(0, 2L);
        //数组中索引0上的数与1进行比较,
        //相同着返回true,并修改数组中的值为3;
        //不相同返回false,不做修改.
        atomicLongArray.compareAndSet(0, 1L, 3L);
        //与compareAndSet一致
        atomicLongArray.weakCompareAndSet(0, 1L, 3L);

        //变更函数
        LongBinaryOperator longBinaryOperator = (left, right) -> left+right;
        //返回数组中索引0上的值,并根据函数结果变更数组中的值
        atomicLongArray.getAndAccumulate(0, 2L, longBinaryOperator);
        //根据函数结果变更数组中的值,并返回数组中索引0上变更后的值
        atomicLongArray.accumulateAndGet(0, 2L, longBinaryOperator);
    }
}
