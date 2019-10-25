package com.lizz.fundation.spi;

import org.junit.Test;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPIServiceTest {
    @Test
    public void spiTest(){
        //加载接口类对应的配置文件中的实现类
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> iterator = load.iterator();
        //循环获取实现类并执行其中的方法
        while(iterator.hasNext()) {
            SPIService ser = iterator.next();
            ser.exe();
        }
    }
}
