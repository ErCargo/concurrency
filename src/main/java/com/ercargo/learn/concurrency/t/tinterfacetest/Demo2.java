package com.ercargo.learn.concurrency.t.tinterfacetest;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class Demo2 {
    public static void main(String[] args) {
        Info1<String> info1 = new Info1<>("aaa");
        System.out.println(info1.getVar());
    }
}
