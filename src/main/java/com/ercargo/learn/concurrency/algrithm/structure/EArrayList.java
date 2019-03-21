package com.ercargo.learn.concurrency.algrithm.structure;

import java.util.Objects;

/**
 * @author ercargo  on 2019/1/27
 * @DESCRIBE
 */
public class EArrayList<T> implements EList<T> {

    private int size;
    private Object[] dataArray = new Object[0];

    public void add() {

    }

    public boolean add(T o) {
        //确保容量
        ensureCapacity(size + 1);
        dataArray[size] = o;
        size++;
        return true;

    }

    //往指定位置放元素
    public void add(int index, T element) {
        //考虑边界条件
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        //从原始数组的第index个开始， 拷贝size-index个， 从target 的第index+1个开始 放入target中
        //举例: 假设src数组有1 个元素，index下标是: 0， size = 1
        //在数组第0 个位置插入一个元素，
        // 就是：从dataArray(src) 的第0 个元素开始，拷贝长度为size-index=1-0=1 的元素
        // 粘贴到dataArray(target)的第1个元素上
        /**
         * 在指定的原数组中从指定的位置 拷贝一个数组 到目标数组的指定位置；
         * 数组的子序列是从有src 标记的原数组拷贝到有dest 标记的目标数组中；
         * 被拷贝的内容的长度=参数的长度；
         * 在srcPos位置的内容，通过，在原数组的srcPos+length-1位置 被复制到
         */
        System.arraycopy(dataArray, index, dataArray, index + 1, size - index);

        dataArray[index] = element;
        size++;


    }





    public boolean remove(T o) {
        int index = indexOf(o);
        if (index < 0) {
            return false;
        }
        System.arraycopy(dataArray, index + 1, dataArray, index, size - 1 - index);
        dataArray[size - 1] = null;
        size--;
        return true;
    }


    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removeData = (T) dataArray[index];
        System.arraycopy(dataArray, index + 1, dataArray, index, size - 1 - index);
        dataArray[size - 1] = null;
        size--;
        return removeData;
    }


    public void clear() {
        for (int i = 0; i < dataArray.length; i++) {
            dataArray[i] = null;
        }
        size = 0;
    }


    public int size() {
        return this.size();
    }


    @Override
    public int indexOf(T o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, dataArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) dataArray[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < -1 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        dataArray[index] = element;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }


    private void ensureCapacity(int addSize) {
        if (addSize > dataArray.length) {
            int newCapacity = Math.max(addSize, dataArray.length * 2);
            Object[] newDataArray = new Object[newCapacity];
            System.arraycopy(dataArray, 0, newDataArray, 0, dataArray.length);
            dataArray = newDataArray;

        }

    }

    public EIterator<T> iterator() {
        return new ArrayListIterator();
    }


    private class ArrayListIterator implements EIterator<T> {
        private int position;
        //private EArrayList<T> list;

        public ArrayListIterator() {
            /*this.list = list;*/
        }

        @Override
        public boolean hasNext() {
            return position < size();
        }

        @Override
        public T next() {
            if(hasNext()){
                return get(position++);
            }
            return null;
        }
    }
}

