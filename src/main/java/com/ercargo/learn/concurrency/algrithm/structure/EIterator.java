package com.ercargo.learn.concurrency.algrithm.structure;

/**
 * @author ercargo  on 2019/1/27
 * @DESCRIBE
 */
public interface EIterator<T> {
    boolean hasNext();
    T next();
}
