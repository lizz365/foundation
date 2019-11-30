package com.lizz.fundation.pattern.observer;

/**
 * @author lizz365
 */
public class UserWallet extends Order {
    private String opStr = "用户钱包";
    @Override
    public void apply(String  orderId) {
        System.out.println(opStr + "减少" + orderId);
    }

    @Override
    public void returnMoney(String  orderId) {
        System.out.println(opStr + "增加" + orderId);
    }
}
