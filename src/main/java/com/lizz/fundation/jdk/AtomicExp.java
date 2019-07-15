package com.lizz.fundation.jdk;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lizz365
 */
public class AtomicExp {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static AtomicReference<User> reference = new AtomicReference<>();
    private static AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
    public static void main(String[] args) {
        System.out.println("***********AtomicInteger***********");
        System.out.println("AtomicInteger o=" + atomicInteger.getAndIncrement());
        System.out.println("AtomicInteger e=" + atomicInteger.get());
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
