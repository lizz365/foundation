package com.lizz.fundation.pattern.template;

/**
 * “赢家”的一生
 */
public class WinnerLife extends Life{
    @Override
    void study() {
        System.out.println("常青藤硕士毕业");
    }

    @Override
    void work() {
        System.out.println("世界五百强高管");
    }

    @Override
    void marry() {
        System.out.println("一家四口大别墅");
    }

    @Override
    void die() {
        System.out.println("裸捐");
    }
}
