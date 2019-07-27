package com.lizz.fundation.jdk.juc.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AbaAtomic
 *
 * @author lizz365
 * @date 19/723
 */
public class AbaAtomic {
    /**
     * 初始化整型标记引用类型
     * 操作类型数据类型为Integer
     * 初始化值为0
     * 初始化版本为1
     */
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(0,1);

    /**
     * 初始化标记布尔型引用类型
     * 操作类型数据类型为Integer
     * 初始化值为0
     * 初始化标记为false
     */
    private static AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference(0,false);

    public static void main(String[] args) {

        //返回当前标记数值
        System.out.println("getStamp:"+atomicStampedReference.getStamp());
        //返回当前引用对象值
        System.out.println("getReference:"+atomicStampedReference.getReference());

        //返回当前引用对象值,并将标记数值存入传入的整型数据0的未位置.
        //传入参数-整型数组,会返回当前版本值
        int[] stampNum = new int[1];
        System.out.println("get:"+atomicStampedReference.get(stampNum));
        System.out.println("stampNum:"+stampNum[0]);

        //设置新标记,
        //参数顺序-当前引用对象,新标记
        //传入对象相等,更新标记,返回true
        //不相等返回false
        System.out.println("attemptStamp :"+atomicStampedReference.attemptStamp(0,2));
        System.out.println("attemptStamp num:"+atomicStampedReference.getStamp());

        //新值新标记
        //参数顺序-引用对象的值,标记版本值
        atomicStampedReference.set(1,2);
        System.out.println("set num:"+atomicStampedReference.getStamp());

        //比较后替换,参数顺序-当前值,替换的值,当前标记值,新的标记值.
        //比较相等替换,返回true
        //比较不相等,返回false
        System.out.println("compareAndSet:"+atomicStampedReference.compareAndSet(1,2,2,3));
        System.out.println("compareAndSet num:"+atomicStampedReference.getStamp());

        //同compareAndSet
        atomicStampedReference.weakCompareAndSet(2,3,3,4);
        System.out.println("weakCompareAndSet num:"+atomicStampedReference.getStamp());

        //atomicMarkableReference操作与atomicStampedReference基本相同
        //返回布尔型标记值
        System.out.println("isMarked:"+atomicMarkableReference.isMarked());
//        输出:
//        getStamp:1
//        getReference:0
//        get:0
//        stampNum:1
//        attemptStamp :true
//        attemptStamp num:2
//        set num:2
//        compareAndSet:true
//        compareAndSet num:3
//        weakCompareAndSet num:4
//        isMarked:false
    }
}
