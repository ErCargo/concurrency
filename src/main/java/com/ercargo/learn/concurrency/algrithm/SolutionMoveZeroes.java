package com.ercargo.learn.concurrency.algrithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ercargo  on 2019/4/6
 * @DESCRIBE leetcode No.283 删除数组中0元素， 其他元素保持原来顺序
 */
public class SolutionMoveZeroes {
    public void moveZeroes(int[] arr) {
        List<Integer> nonzeroElement = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                //不为0 的元素放入nonzeroElement中
                nonzeroElement.add(arr[i]);
            }
        }
        //然后放入arr中
        for (int j = 0; j < nonzeroElement.size(); j++) {
            arr[j] = nonzeroElement.get(j);
        }

        //其余元素补0
        for (int i = nonzeroElement.size(); i < arr.length; i++) {
            arr[i] = 0;
        }

    }


    public void move(int[] arr) {
        //存放非0元素的指针
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k] = arr[i];
                k++;
            }
        }
        for (int i = k; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    /**
     * 未实现交换
     *
     * @param nums
     */
    public void move2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                System.out.println("交换前：" + nums[i] + "," + nums[k]);
                swap(nums, i,k);

                k++;
            }

        }
    }

    /**
     * Java对普通类型的变量是不支持引用传递的
     */
    public void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        SolutionMoveZeroes solution = new SolutionMoveZeroes();
        //solution.moveZeroes(arr);

        solution.move2(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
