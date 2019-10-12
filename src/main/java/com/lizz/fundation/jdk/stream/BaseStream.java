package com.lizz.fundation.jdk.stream;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * @author lizz365
 */
public class BaseStream {


    public static void main(String[] args) {
//        String[] chars = new String[]{"a","bb","c"};
//        Arrays.stream(chars).filter( str -> str.length()==1).forEach((str -> System.out.println(str) ));
        System.out.println(1 << 30);
        System.out.println(Integer.MAX_VALUE);
        String key="a";
        int h = key.hashCode();
        System.out.println(h);
        System.out.println(h >>> 16);
        System.out.println();
    }
}