package com.lizz.fundation.leetcode;

/**
 * @author lizz365
 */
public class Josephus {
    /**
     * 总人数
     */
    static final int nums = 41;
    /**
     * 每次第几个人被淘汰
     */
    static final int killMan = 2;

    public static void main(String[] args) {
        alives(1);
        alivesNum();
    }
    /**
     * 约瑟夫环算法
     * @param alive 存活人数
     */
    public static void alives(int alive) {
        //未被淘汰的都被标记为0
        int[] man = new int[nums];
        // 数组角标
        int pos = -1;
        //计数，用于比对每次需要淘汰的计数
        int i = 0;
        //标记被淘汰的顺序
        int count = 1;
        //被淘汰人数不能超过总人数
        int num=1;
        while (count <= nums) {
            do {
                num++;
                //重置循环起始位
                pos = (pos + 1) % nums;
                //当值为0是计数
                if (man[pos] == 0)
                    i++;
                //当前位置为淘汰位时
                if (i == killMan) {
                    //重置计数位，跳出本次淘汰操作
                    i = 0;
                    break;
                }

            } while (true);
            //标记第pos位为第count个被淘汰的人
            man[pos] = count;
            //下一次淘汰顺位
            count++;
        }
        //最后一个淘汰顺位
        int outNum = count - alive;
        for (int j = 0; j < man.length; j++) {
            //大于最后一个淘汰顺位的人都存活了
            if (man[j] >= outNum)
                System.out.println("不被杀的位置是->" + (j + 1));
        }
        System.out.println(num);
    }

    public static void alivesNum() {
        int fn = 0;
        for (int i=2; i<=nums; i++) {
            fn = (fn + killMan) % i;
        }
        fn = fn+1;
        System.out.println("不被杀的位置是->" + fn);
    }
}
