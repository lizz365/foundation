package com.lizz.fundation.jdk.juc;

import java.util.concurrent.atomic.*;

/**
 * @author lizz365
 */
public class AtomicExp {
    //基础类型原子操作
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static LongAdder longAdder = new LongAdder();
    //应用类型原子操作
    private static AtomicReference<User> reference = new AtomicReference<>();
    //应用类型中的参数进行原子操作
    private static AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static void main(String[] args) {
        System.out.println("***********AtomicInteger***********");
        System.out.println("AtomicInteger o=" + atomicInteger.getAndIncrement());
        System.out.println("AtomicInteger e=" + atomicInteger.get());
        System.out.println("***********longAdder***********");
        System.out.println("longAdder sum = " + longAdder.sum());
        longAdder.add(200);
        System.out.println("longAdder.add(200);sum = " + longAdder.sum());
        longAdder.increment();
        System.out.println("longAdder.increment(); sum = " + longAdder.sum());
        longAdder.decrement();
        System.out.println("longAdder.decrement(); sum = " + longAdder.sum());
        System.out.println("longAdder.sumThenReset(); sum = " + longAdder.sumThenReset());
        System.out.println("longAdder sum =  " + longAdder.sum());
        System.out.println("***********AtomicReference***********");
        User user1 = new User("a", 1);
        reference.set(user1);
        User user2 = new User("b", 2);
        User user = reference.getAndSet(user2);
        System.out.println("AtomicReference o=" + user.toString());
        System.out.println("AtomicReference e=" + reference.toString());
        System.out.println("***********AtomicIntegerFieldUpdater***********");
        int oldValue = updater.getAndAdd(user, 5);
        System.out.println("AtomicIntegerFieldUpdater o=" + oldValue);
        System.out.println("AtomicIntegerFieldUpdater n=" + updater.get(user));

    }

    static class User {
        private String userName;
        public volatile int age;

        public User(String userName, int age) {
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
