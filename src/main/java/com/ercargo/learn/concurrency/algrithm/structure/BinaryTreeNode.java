package com.ercargo.learn.concurrency.algrithm.structure;

/**
 * @author ercargo  on 2019/1/28
 * @DESCRIBE 二分搜索树
 */
public class BinaryTreeNode<T extends Comparable> {
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private int size;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public BinaryTreeNode<T> insert(T data) {
        if (this.data == null) {
            this.data = data;
            return this;
        }
        int compareReuslt = this.data.compareTo(data);
        if (compareReuslt > 0) {
            if (this.left == null) {
                this.left = new BinaryTreeNode<>();
                this.left.data = data;
                return this.left;
            } else {
                return this.left.insert(data);
            }
        } else if (compareReuslt < 0) {
            if (this.right == null) {
                this.right = new BinaryTreeNode<>();
                this.right.data = data;
                return this.right;
            } else {
                return this.right.insert(data);
            }
        } else {
            return this;
        }
    }


}
