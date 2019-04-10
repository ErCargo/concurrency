package com.ercargo.learn.concurrency.algrithm.structure;

/**
 * @author ercargo  on 2019/4/8
 * @DESCRIBE 二分搜索树
 * 类型必须拥有可比较性
 */
public class Tree<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * 根结点
     */
    private Node root;
    private int size;

    public Tree() {
        root = null;
        size = 0;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            /**
             * 递归调用
             */
            add(root, e);
        }
    }

    private void add(Node node, E e) {
        /**
         * 递归终止条件
         */
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0) {

        }
    }

}
