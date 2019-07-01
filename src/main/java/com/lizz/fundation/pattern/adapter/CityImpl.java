package com.lizz.fundation.pattern.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizz365
 */
public class CityImpl implements City {
    private Map<String,String> cityMap;
    public CityImpl(){
        cityMap = new HashMap<>();
        cityMap.put("bj","北京");
        cityMap.put("tj","天津");
    }
    public String getCityByCode(String code){
        return cityMap.get(code);
    }
}
