package com.ercargo.learn.concurrency.algrithm.sort;

/**
 * @author ercargo  on 2019/1/22
 * @DESCRIBE
 */
public class HeapSort {
    /**
     * 堆排序----选择排序，最坏，最好，平均的时间复杂度是O(nlogn)
     * 堆结构： 完全二叉树，每个结点的值都>=其左右孩子结点的值（大顶堆）;或每个结点的值都<=其左右孩子的结点的值（小顶堆）
     * 堆排序的主要思路：
     * 1. 从第一个非叶子节点开始，arr.length/2-1,构造大顶堆、小顶堆
     * 2. 交换堆顶和堆底的元素，将最大/最小元素放入数组
     * 3. 重复步骤2， 直到得到有序序列
     * 大顶堆： arr[i]>=arr[2i+1]>=arr[2i+2]
     * 小顶堆： arr[i]<=arr[2i+1]<=arr[2i+2]
     */

    /*public static void main(String[] args) {

    }*/
    public static void sort() {

    }

    public static void main(String[] args) {
        switchDemo(0);
    }


    public static void switchDemo(int n) {
        switch (n) {
            case 0:
                System.out.println("first");
            case 1:
            case 2:
                System.out.println("second");
                break;
            default:
                System.out.println("end");

        }
    }

}
