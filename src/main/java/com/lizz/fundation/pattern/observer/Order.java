package com.lizz.fundation.pattern.observer;

/**
 * 订单
 * @author lizz365
 */
public interface Order {
    void apply(String  orderId);

    void returnMoney(String  orderId);
}
