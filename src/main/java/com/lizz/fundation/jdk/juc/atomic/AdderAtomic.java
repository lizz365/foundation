package com.lizz.fundation.jdk.juc.atomic;

import java.util.concurrent.atomic.LongAdder;

/**
 * AdderAtomic
 *
 * @author lizz365
 * @date 19/7/22
 */
public class AdderAtomic {
    /**
     * 生成累加器,起始默认为0
     */
    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) {
        //返回统计结果
        longAdder.sum();
        //返回累计结果并重置累加器
        longAdder.sumThenReset();
        //累加1
        longAdder.increment();
        //累减1
        longAdder.decrement();
        //指定累加值
        longAdder.add(2);
        //重置累加器
        longAdder.reset();
    }
}
