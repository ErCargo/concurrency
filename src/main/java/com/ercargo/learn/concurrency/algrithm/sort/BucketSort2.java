package com.ercargo.learn.concurrency.algrithm.sort;

/**
 * @author ercargo  on 2019/1/22
 * @DESCRIBE
 */
public class BucketSort2 {
    public static void main(String[] args) {
        int[] arr = new int[1001];
        int i;
        int j;
        int t;

        int[] origin = {100,52, 200, 30, 8,8, 999, 1000, 73, 52};

        for (i = 1000; i >= 0; i--) {
            arr[i] = 0;
        }


        for (i = 0; i <origin.length; i++) {
            t = origin[i];
            arr[t]++;
        }

        for (i = 1000; i >= 0; i--) {
            for (j = 1; arr[i] >= j; j++) {
                System.out.print("最终结果：" + i+"\n");
            }
        }
    }
}
