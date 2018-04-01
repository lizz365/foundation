package com.lizz.fundation.pattern.proxyFactory;

/**
 * @author lizz365
 */
public class ReadDBImpl implements ReadDB {
    public String select(){
        System.out.println("进入被代理方法");
        return "查询到的数据";
    }
}
