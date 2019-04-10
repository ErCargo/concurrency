package com.ercargo.learn.concurrency.algrithm.testagain;


/**
 * @author ercargo  on 2019/4/7
 * @DESCRIBE
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {9, 8, 1, 5, 6, 10, 3, 0, 2};
        //8 9 1 5 6 10 3 0 2
        //8 1 9 5 6 10 3 0 2
        //8 1 5 9 6 10 3 0 2
        //8 1 5 6 9 10 3 0 2
        //8 1 5 6 3 9 10 0 2
        //8 1 5 6 3 0 9 10 2
        //8 1 5 6 3 0 2 9 10
        int target = 2;
        //有序的情况下进行二分查找
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        int isFind = bSearch(nums, target);
        System.out.println(isFind);

    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = part(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    /**
     * 拆分,使左边的都小于pivot ,右边的都大于pivot
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int part(int[] nums, int l, int r) {
        //指针指向最左边的元素
        int pivot = nums[l]; //9
        int j = l;           //
        for (int i = l; i <= r; i++) {
            if (nums[i] < pivot) {
                swap(nums, j+1, i);
                j++;
            }
        }
        swap(nums, l, j);
        return j;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int bSearch(int[] nums, int target) {
        //二分法查找
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;

    }
}
