package com.lizz.fundation.pattern.template;

/**
 * “屌丝”的一生
 */
public class LoserLife extends Life {
    @Override
    void study() {
        System.out.println("高中毕业");
    }

    @Override
    void work() {
        System.out.println("工地搬砖");
    }

    @Override
    void marry() {
        System.out.println("一家N口郊区房");
    }

    @Override
    void die() {
        System.out.println("山中一土堆");
    }
}
