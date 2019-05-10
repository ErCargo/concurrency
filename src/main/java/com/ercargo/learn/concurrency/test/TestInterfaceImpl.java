package com.ercargo.learn.concurrency.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ercargo  on 2019/5/7
 * @DESCRIBE
 */
public class TestInterfaceImpl implements TestInterface {
    @Override
    public void doSomeThing() {
        System.out.println("aaa");
    }




    public static void main(String[] args) {
        TestInterfaceImpl a = new TestInterfaceImpl();
        a.doSomeThing();
        a.doAnother();
        List<String> list = new ArrayList<>();
        list.forEach(r->{

        });

    }
}
