package com.ercargo.learn.concurrency.t.tinterfacetest;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class InfoImpl implements Info<String> {

    private String var;

    public InfoImpl(String var) {
        this.var = var;
    }

    @Override
    public void setVar(String var) {
        this.var = var;
    }


    @Override
    public String getVar() {
        return this.var;
    }



}

