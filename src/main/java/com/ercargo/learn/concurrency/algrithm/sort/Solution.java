package com.ercargo.learn.concurrency.algrithm.sort;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ercargo  on 2019/1/24
 * @DESCRIBE
 */
public class Solution {
    /**
     * 两数之和
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] index = new int[2];

        index = twoNum3(nums, target);
        for (int i = 0; i <= index.length - 1; i++) {
            System.out.println(index[i]);
        }

    }


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoNum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i) {
                return new int[]{i, map.get(result)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoNum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{i, map.get(result)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
