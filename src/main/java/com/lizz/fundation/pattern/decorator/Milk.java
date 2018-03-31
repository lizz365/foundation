package com.lizz.fundation.pattern.decorator;

import java.util.HashMap;
import java.util.Map;

/**
 * 咖啡加牛奶
 * @author lizz365
 */
public class Milk extends Coffee{
    private Map<String,Integer> map;
    private Coffee coffee;

    public Milk(Coffee coffee, int size){
        this.coffee = coffee;
        this.map = new HashMap<>();
        this.map.put("milk",size);
    }

    @Override
    public Map<String,Integer> make() {
        this.map.putAll(this.coffee.make());
        return this.map;
    }
}
