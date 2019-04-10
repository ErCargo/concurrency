package com.ercargo.learn.concurrency.algrithm;


/**
 * @author ercargo  on 2019/4/7
 * @DESCRIBE
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int remove = 2;
        int count = removeEle(arr, remove);
        System.out.println(count);
    }

    private static int removeEle(int[] arr, int remove) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == remove) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            }
            count = count + 1;
        }

        return count;
    }
}
