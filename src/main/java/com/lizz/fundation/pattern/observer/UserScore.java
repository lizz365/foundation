package com.lizz.fundation.pattern.observer;

/**
 * @author lizz365
 */
public class UserScore implements Order {
    private String opStr ="退换积分";
    @Override
    public void apply(String  orderId) {
        System.out.println(opStr + "增加" + orderId);
    }

    @Override
    public void returnMoney(String  orderId) {
        System.out.println(opStr + "减少" + orderId);
    }
}
