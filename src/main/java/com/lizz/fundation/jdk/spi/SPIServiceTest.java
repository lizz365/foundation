package com.lizz.fundation.jdk.spi;

import org.junit.Test;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 服务发现机制
 */
public class SPIServiceTest {
    @Test
    public void spiTest(){
        //加载接口类对应的配置文件中的实现类 com.lizz.fundation.jdk.spi.SPIService
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> iterator = load.iterator();
        //循环获取实现类并执行其中的方法
        while(iterator.hasNext()) {
            SPIService ser = iterator.next();
            ser.exe();
        }
    }
}
