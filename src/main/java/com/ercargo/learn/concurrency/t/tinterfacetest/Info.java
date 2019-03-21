package com.ercargo.learn.concurrency.t.tinterfacetest;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public interface Info<T>{
    T getVar();
    void setVar(T var);

}
