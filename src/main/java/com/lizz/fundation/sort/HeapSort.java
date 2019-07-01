package com.lizz.fundation.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * HeapSort
 * 堆排序(Heap Sort)是利用堆进行排序的方法。
 * 其基本思想为：
 * 将待排序列构造成一个大顶堆(或小顶堆)，整个序列的最大值(或最小值)就是堆顶的根结点，
 * 将根节点的值和堆数组的末尾元素交换，此时末尾元素就是最大值(或最小值)，
 * 然后将剩余的n-1个序列重新构造成一个堆，这样就会得到n个元素中的次大值(或次小值)，
 * 如此反复执行，最终得到一个有序序列。
 * @author zhenzhong.li
 * @date 19/1/8
 */
public class HeapSort {
    /**
     * @param arr    待调整的数组
     * @param i      待调整的结点的下标
     * @param length 数组的长度
     */
    private static void adjust(int arr[], int i, int length) {
        // 调整i位置的结点
        // 先保存当前结点的下标
        int max = i;
        // 当前结点左右孩子结点的下标
        int lchild = i * 2 + 1;
        int rchild = i * 2 + 2;
        if (lchild < length && arr[lchild] > arr[max]) {
            max = lchild;
        }
        if (rchild < length && arr[rchild] > arr[max]) {
            max = rchild;
        }
        // 若i处的值比其左右孩子结点的值小，就将其和最大值进行交换
        if (max != i) {
            int temp;
            temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            // 递归
            adjust(arr, max, length);
        }
    }

    public static void sort(int arr[]) {
        int length = arr.length;
        // 初始化堆
        // length / 2 - 1是二叉树中最后一个非叶子结点的序号
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, length);
        }
        // 交换堆顶元素和最后一个元素
        for (int i = length - 1; i >= 0; i--) {
            int temp;
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i);
        }
    }
    public static void main(String[] arg){
        int[] arr = {3,5,2,5,6,1};
        HeapSort.sort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }
}
