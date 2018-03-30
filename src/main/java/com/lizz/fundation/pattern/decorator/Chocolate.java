package com.lizz.fundation.pattern.decorator;

import java.util.HashMap;
import java.util.Map;

/**
 * 咖啡加上巧克力
 * @author lizz365
 */
public class Chocolate extends Coffee{
    private Map map;
    private Coffee coffee;

    public Chocolate(Coffee coffee, int size){
        this.coffee = coffee;
        this.map = new HashMap();
        this.map.put("chocolate",size);
    }

    @Override
    public Map make() {
        this.map.putAll(this.coffee.make());
        return this.map;
    }
}
