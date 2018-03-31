package com.lizz.fundation.pattern.adapter;

/**
 * @author lizz365
 */
public class CityAdapter implements City {
    private City city;

    public CityAdapter(City city){
        this.city = city;
    }
    /**
     * 外部code 转成内部code
     * @param code 代码
     * @return String
     */
    public String getCityByCode(String code){
        if(code != null){
            switch (code){
                case "1":code = "bj";break;
                case "2":code = "tj";break;
                default: return "";
            }
        }
        return city.getCityByCode(code);

    }
}
