package com.lizz.fundation.pattern.observer;

/**
 * 订单
 * @author lizz365
 */
public abstract class Order {
     abstract void apply(String  orderId);

     abstract void returnMoney(String  orderId);
}
