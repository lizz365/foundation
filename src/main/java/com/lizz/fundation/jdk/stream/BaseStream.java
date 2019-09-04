package com.lizz.fundation.jdk.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author lizz365
 */
public class BaseStream {


    public static void main(String[] args) {
        String[] chars = new String[]{"a","bb","c"};
        Arrays.stream(chars).filter( str -> str.length()==1).forEach((str -> System.out.printf(str) ));

    }
}