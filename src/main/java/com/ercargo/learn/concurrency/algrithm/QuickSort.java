package com.ercargo.learn.concurrency.algrithm;

/**
 * @author ercargo  on 2019/4/6
 * @DESCRIBE
 */
public class QuickSort {


    public static void quickSort(int[] arr) {
        _quickSort(arr, 0, arr.length - 1);
    }

    private static void _quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        _quickSort(arr, l, p - 1);
        _quickSort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int j = l;
        for (int i = l; i <=r; i++) {
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
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }
}
