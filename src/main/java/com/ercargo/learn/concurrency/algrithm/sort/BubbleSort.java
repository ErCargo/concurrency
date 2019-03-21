package com.ercargo.learn.concurrency.algrithm.sort;

/**
 * @author ercargo  on 2019/1/23
 * @DESCRIBE
 */
public class BubbleSort {
    /**
     * 冒泡排序：
     * 每次比较2个相邻元素的大小， 交换错误的顺序
     * 时间复杂度是O(N2)
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        int j;
        int tmp;


        //int[] origin = {53, 98, 10, 20, 9, 28, 65};

        int[] origin = {9, 8, 7, 6, 5, 4, 3};
        for (i = 1; i <= origin.length - 1; i++) { //循环趟数， 有N个数，循环N-1趟
            System.out.println("i:=" + i);
            for (j = 0; j < origin.length - i; j++) { //
                if (origin[j] > origin[j + 1]) {
                    tmp = origin[j];
                    origin[j] = origin[j + 1];
                    origin[j + 1] = tmp;
                }
            }
        }


        for (i = 0; i <= origin.length - 1; i++) {
            // System.out.println("i:=="+i+"\n");
            System.out.print("origin[" + i + "]:==" + origin[i] + "\n");
        }

    }
}
