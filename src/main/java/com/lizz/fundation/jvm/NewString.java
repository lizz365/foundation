package com.lizz.fundation.jvm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lizz365
 */
public class NewString {
    public static void main(String[] args) {
        //基本数据类型，存放在栈内存中
//        int  n1= 999;
//        //str为引用类型，存放在栈内存中
//        //b为常量，存放在常量池中，并驻留
        String str1 = "b";
//        //因为上面已经在常量池中创建了"b"常量,这里直接引用
//        //所以str和str1都指向了常量池中的b
//        String str2 = "b";
//        //new String("c")存放在对内存中
//        String str3 = new String("c");
        String str4 = new String("c");
        String str5 = str4+"d";
        System.out.printf(str5);
        Map map = new HashMap(10);
        Map map1 = new ConcurrentHashMap(10);

        map.put("a","c");
        map1.put("a","c");

    }
}
