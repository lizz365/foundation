package com.lizz.fundation.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizz365
 */
public class Apply {
    List<Order> list = new ArrayList<>();

    public void addOrder(Order order){
        list.add(order);
    }

    public boolean apply(String orderId){
        for(Order order : list){
            order.apply(orderId);
        }
        return true;
    }

    public boolean refundMoney(String orderId){
        for(Order order : list){
            order.returnMoney(orderId);
        }
        return true;
    }
}
