package com.ercargo.learn.concurrency.algrithm.structure;

import java.util.EmptyStackException;
import java.util.Objects;

/**
 * @author ercargo  on 2019/1/28
 * @DESCRIBE
 */
public class EStack<T> {
    private int size;
    private Object[] dataArray = {};

    public EStack() {
    }

    public int size() {
        return size;
    }

    public T push(T item) {
        ensureCapacity(size + 1);
        this.dataArray[size] = item;
        this.size++;
        return item;
    }


    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T data = (T) this.dataArray[size - 1];
        this.dataArray[size - 1] = null;
        this.size--;
        return data;
    }

    /**
     * 查看栈顶元素而不移除
     *
     * @return
     */
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (T) dataArray[size - 1];
    }


    public boolean empty() {
        return size == 0;
    }


    public synchronized int search(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(0, dataArray[i])) {
                return i;
            }
        }
        return -1;
    }


    private void ensureCapacity(int minCapacity) {
        if (minCapacity > dataArray.length) {
            int newCapacity = Math.max(minCapacity, dataArray.length * 2);
            Object[] newDataArray = new Object[newCapacity];
            System.arraycopy(dataArray, 0, newDataArray, 0, dataArray.length);
            dataArray = newDataArray;
        }
    }

}
