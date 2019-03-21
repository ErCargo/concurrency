package com.ercargo.learn.concurrency.t.tinterfacetest;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 * 利用泛型类构造填充泛型接口
 */
public class Info1<T> implements Info<T> {
    private T var;

    public Info1(T var){
        this.setVar(var);
    }


    @Override
    public T getVar() {
        return null;
    }

    @Override
    public void setVar(T var) {
        this.var = var;
    }
}
