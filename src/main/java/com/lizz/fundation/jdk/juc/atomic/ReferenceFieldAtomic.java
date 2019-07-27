package com.lizz.fundation.jdk.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * BaseAtomic
 *
 * @author lizz365
 * @date 19/7/22
 */
public class ReferenceFieldAtomic {
    /**
     * 初始化为0
     */
    private static final AtomicIntegerFieldUpdater<User> REFERENCE = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    public static void main(String[] args) {
        User user = new User("a", 1);
        //设置引用对象为user属性age为2
        REFERENCE.set(user,2);
        //本地内存设置,不保证线程可见
        REFERENCE.lazySet(user,2);
        //返回user对象中的age
        REFERENCE.get(user);
        //返回user对象的age属性,并变更为age为2
        REFERENCE.getAndSet(user,2);
        //返回对象user属性age的值,并修改age加1
        REFERENCE.getAndIncrement(user);
        //修改对象user属性age的值加1,并返回age
        REFERENCE.incrementAndGet(user);
        //返回对象user属性age的值,并修改age减1
        REFERENCE.getAndDecrement(user);
        //修改对象user属性age的值减1,并返回age
        REFERENCE.decrementAndGet(user);
        //一元操作函数
        IntUnaryOperator intUnaryOperator = operand -> ++operand;
        //返回当前user对象的age值,并将user的age值修改为一元操作函数结果
        REFERENCE.getAndUpdate(user,intUnaryOperator);
        //将user的age值修改为一元操作函数结,并返回更改后user对象的age值
        REFERENCE.updateAndGet(user,intUnaryOperator);

        //二元擦破在函数
        //left:传入对象属性age的值
        //right:传入的第二个参数值
        IntBinaryOperator binaryOperator = (left, right) -> left+left;
        //获取修改前user的age的值,并将引用age更新为二元函数返回的对象.
        REFERENCE.getAndAccumulate(user,2,binaryOperator);
        //将引用user中属性值age更新为二元函数返回的值,并获取变更后的age值
        REFERENCE.accumulateAndGet(user,2,binaryOperator);
        //当前引用对象user属性age与1比较
        //相等返回true,并设置引用对象user属性age为user2
        //不相等返回false,不做变更
        REFERENCE.compareAndSet(user,1,2);
        //与compareAndSet一致
        REFERENCE.weakCompareAndSet(user,1,2);
    }

    private static class User {
        private String userName;
        volatile int age;

        User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }
        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
