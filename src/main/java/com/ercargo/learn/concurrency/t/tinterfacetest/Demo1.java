package com.ercargo.learn.concurrency.t.tinterfacetest;

public class  Demo1{
    public static void main(String[] args) {
        InfoImpl i = new InfoImpl("aaa");
        System.out.println(i.getVar());
    }

}
