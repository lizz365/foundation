package com.lizz.fundation.pattern.decorator;

import java.util.HashMap;
import java.util.Map;

/**
 * 浓缩咖啡
 * @author lizz365
 */
public class Coffee {
    private Map<String,Integer> map;
    Coffee(){

    }

    public Coffee(int size){
        map = new HashMap<>();
        map.put("base",size);
    }

    public Map<String,Integer> make(){
        return this.map;
    }
}
