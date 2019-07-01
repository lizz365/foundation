package com.lizz.fundation.sort;

/**
 * SelectionSort
 * 每一趟在n-i+1(i=1,2,...,n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。
 * 具体来说，假设长度为n的数组arr，要按照从小到大排序，那么先从n个数字中找到最小值min1，
 * 如果最小值min1的位置不在数组的最左端(也就是min1不等于arr[0])，则将最小值min1和arr[0]交换，
 * 接着在剩下的n-1个数字中找到最小值min2，如果最小值min2不等于arr[1]，则交换这两个数字，依次类推，直到数组arr有序排列。
 * 算法的时间复杂度为O(n^2)。
 * @author zhenzhong.li
 * @date 19/1/8
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index == i)
                continue;
            else {
                int temp;
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
