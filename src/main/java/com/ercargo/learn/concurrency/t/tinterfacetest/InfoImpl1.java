package com.ercargo.learn.concurrency.t.tinterfacetest;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class InfoImpl1<T,K,U> implements  Info<T> {

    private T var;
    private U x;
    private K y;


    public InfoImpl1(T var) {
       this.setVar(var);
    }



    @Override
    public T getVar() {
        return this.var;
    }

    @Override
    public void setVar(T var) {
        this.var = var;
    }
}
