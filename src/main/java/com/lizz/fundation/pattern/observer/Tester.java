package com.lizz.fundation.pattern.observer;

import org.junit.Test;

/**
 * @ClassName ObserverTest
 * @Description: 观察者模式
 * @Author lizz365
 * @Date 2019/11/29
 **/
public class Tester {
    @Test
    public void observer(){
        Apply apply = new Apply();
        UserScore userScore = new UserScore();
        UserWallet userWallet = new UserWallet();
        apply.addOrder(userScore);
        apply.addOrder(userWallet);

        apply.apply("111");
    }
}
