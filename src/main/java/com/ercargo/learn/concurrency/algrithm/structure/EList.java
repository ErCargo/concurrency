package com.ercargo.learn.concurrency.algrithm.structure;

/**
 * @author ercargo  on 2019/1/27
 * @DESCRIBE
 */
public interface EList<T> {

    int size();
    boolean isEmpty();
    boolean contains(T o);

    Object[] toArray();

    boolean add(T o);

    int indexOf(T o);

    T get(int index);
    T set(int index, T element);

    T remove(int index);

    boolean remove(T o);



}
