package com.lizz.fundation.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * BubbleSort
 * 先从数组中找到最大值(或最小值)并放到数组最左端(或最右端)，
 * 然后在剩下的数字中找到次大值(或次小值)，以此类推，直到数组有序排列。
 * 算法的时间复杂度为O(n^2)。
 * @author zhenzhong.li
 * @date 19/1/8
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] arg){
        int[] arr = {3,5,2,5,6,1};
        BubbleSort.sort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }
}
