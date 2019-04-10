package com.ercargo.learn.concurrency.algrithm;

/**
 * @author ercargo  on 2019/4/6
 * @DESCRIBE 最大K个数，基于快排
 */
public class KthData {

    public static int findK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return arr[k-1 ];
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);

    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int j = l;
        for (int i = l; i <= r; i++) {
            if (arr[i] < pivot) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int kth = findK(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        System.out.println("------------------------");
        System.out.println(kth);
    }
}
