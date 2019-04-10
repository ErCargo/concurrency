package com.ercargo.learn.concurrency.algrithm.testagain;

/**
 * @author ercargo  on 2019/4/7
 * @DESCRIBE
 */
public class MoveZero {
    public static void move(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int k = 0;
        for (int i = 0; i < r; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, i, k);
                    k++;
                }else{
                    k++;
                }

            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 4, 0, 5, 0};

        move(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
