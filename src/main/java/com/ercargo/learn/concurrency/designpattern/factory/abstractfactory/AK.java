package com.ercargo.learn.concurrency.designpattern.factory.abstractfactory;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class AK implements  Gun {
    @Override
    public void shooting() {
        System.out.println("shooting with AK");
    }
}
