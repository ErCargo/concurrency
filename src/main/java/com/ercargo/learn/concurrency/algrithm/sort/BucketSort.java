package com.ercargo.learn.concurrency.algrithm.sort;

/**
 * @author ercargo  on 2019/1/22
 * @DESCRIBE
 */
public class BucketSort {
    /**
     * 桶排序时间复杂度O(M+N)
     * @param args
     */
    public static void main(String[] args) {
        //声明一个长度为11 的数字
        int[] arr = new int[11];

        int i = 0;
        int j = 0;
        int t = 0;
        for (i = 0; i <= 10; i++) {
            arr[i] = 0;
        }

        int[] origin = {5, 3, 5, 2, 8};

        for (j = 0; j < origin.length; j++) {
            t = origin[j];
            arr[t]++;
            System.out.print("t:"+t+"==");
            System.out.print("arr["+t+"]="+arr[t]+"\n");
        }

        for(i=0;i<=arr.length-1;i++){
            //System.out.print("arr["+i+"]="+arr[i]+"\n");
            for(j=1;arr[i]>=1;j++){
                System.out.print("最终结果："+i+"\n");
            }
        }
    }
}
