package com.ercargo.learn.concurrency.algrithm.sort;

/**
 * @author ercargo  on 2019/1/23
 * @DESCRIBE
 */
public class QuickSort {
    /**
     * 快排：基于二分思想，选取基准数， 从小到大排序：将大于基准数的放到右边，将小于基准数的放到基准数左边
     * 冒泡排序针对相邻两个数交换，浪费时间
     * 时间复杂度: 最坏时间复杂度=O(N2)=冒泡排序的时间复杂度
     * 平均时间复杂度:O(NlogN)
     *
     * @param args
     */

    static int[] origin = {28, 19, 13, 89, 40, 55, 71, 31, 22};

    public static void main(String[] args) {
        int i;
        quickSort(0, origin.length - 1);

        for (i = 0; i < origin.length; i++) {
            System.out.println("快排结果：" + origin[i]);
        }
    }

    public static void quickSort(int left, int right) {
        int i, j, t, tmp;
        if (left > right || left >= origin.length || right >= origin.length) {
            return;
        }
        tmp = origin[left]; // 基准数
        i = left;
        j = right;

        while (i != j) {
            System.out.println("i=:" + i + "j:=" + j);
            System.out.println("origin[" + j + "]=" + origin[j] + "------origin[" + i + "]=" + origin[i]);
            System.out.println("当前基准值" + tmp);
            //找到右边比tmp大的不动，否则左移
            while (origin[j] >= tmp && i < j) {
                j--;
            }
            //找到左边比tmp小的不动，否则右移
            while (origin[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                t = origin[i];
                origin[i] = origin[j];
                origin[j] = t;
            }
        }
        System.out.println("i和j 相等：i=:" + i + "j:=" + j);

        origin[left] = origin[i];
        origin[i] = tmp;


        quickSort(left, i - 1);

        quickSort(i +1, right);

    }
}
