package com.lizz.fundation.jdk.juc.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * BaseAtomic
 *
 * @author lizz365
 * @date 19/7/22
 */
public class ReferenceAtomic {
    /**
     * 初始化为0
     */
    private static AtomicReference<User> reference = new AtomicReference<>();

    public static void main(String[] args) {
        User user1 = new User("a", 1);
        //设置引用对象为user
        reference.set(user1);
        //本地内存设置,不保证线程可见
        reference.lazySet(user1);
        //获取user对象
        reference.get();
        //获取并变更为user2
        User user2 = new User("b", 2);
        reference.getAndSet(user2);

        //一元操作函数
        UnaryOperator<User> unaryOperator = new UnaryOperator(){
            @Override
            public Object apply(Object o) {
                User user1 = (User) o;
                user1.setAge(11);
                return user1;
            }
        };
        //返回当前引用,并对将引用对象修改为一元操作函数结果
        reference.getAndUpdate(unaryOperator);

        //二元擦破在函数
        BinaryOperator<User> binaryOperator = new BinaryOperator(){
            /**
             *
             * @param o 变更前引用对象
             * @param o2 传入的对象
             * @return
             */
            @Override
            public Object apply(Object o, Object o2) {
                User user1 = (User) o;
                User user2 = (User) o2;
                user1.setAge(user2.age);
                return user1;
            }
        };
        //获取当前引用对象,并将引用对象更新为二元函数返回的对象.
        reference.getAndAccumulate(user1,binaryOperator);
        //将引用对象更新为二元函数返回的对象,并获取变更后的引用对象
        reference.accumulateAndGet(user2,binaryOperator);
        //当前引用对象与user2比较
        //相等返回true,并设置引用对象为user2
        //不相等返回false,不做变更
        reference.compareAndSet(user1,user2);
        //与compareAndSet一致
        reference.weakCompareAndSet(user1,user1);
    }

    private static class User {
        private String userName;
        volatile int age;

        User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }

        void setAge(int age) {
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
