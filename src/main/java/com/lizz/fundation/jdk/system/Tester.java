package com.lizz.fundation.jdk.system;

import org.junit.Test;

/**
 * @ClassName SystemFunction
 * @Description: System的方法
 *@Author lizz365
 * @Date 2019/12/1
 **/
public class Tester {
    @Test
    public void arraycopy(){
        String str = "abcdefg1234567";
        char[] chars = str.toCharArray();
        char copyChars[] = new char[chars.length];
        System.arraycopy(chars, 0, copyChars, 0, chars.length);
        System.out.println(copyChars);
    }

}
