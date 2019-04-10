package com.ercargo.learn.concurrency.algrithm;



/**
 * @author ercargo  on 2019/4/6
 * @DESCRIBE 二分查找法
 * 有序数列，才能使用二分查找法
 */
public class BinarySearch {

    public static int getTarget(int[] arr, int n, int target) {
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        //int n = 100000;
        int[] arr = generateArray();
        long now = System.currentTimeMillis();
        System.out.println(getTarget(arr, arr.length+1, 3 ));
        long now1 = System.currentTimeMillis();
        System.out.println(now1 - now);
    }

    /**
     * 生成一个有序数组
     *
     * @return
     */
    public static int[] generateArray() {
        int[] arr = {5, 1, 3, 6, 2, 7};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            //System.out.println(arr[i]);
        }
        return arr;
    }
}
