package com.ercargo.learn.concurrency.algrithm;

import static com.ercargo.learn.concurrency.algrithm.QuickSort.quickSort;

/**
 * @author ercargo  on 2019/4/6
 * @DESCRIBE
 */
public class TwoSum {

    /**
     *
     * @param arr
     * @param n
     * @param target
     */
    public static int[] getTwoSum(int[] arr, int n, int target) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == (target - arr[i])) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }



    public static void main(String[] args) {
        //有序数组
        int[] arr = {2, 7, 9, 10, 11, 15};
        int target = 9;
        int[] result = getTwoSum(arr, arr.length, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
