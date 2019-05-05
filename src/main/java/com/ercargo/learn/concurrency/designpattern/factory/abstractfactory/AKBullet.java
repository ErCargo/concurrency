package com.ercargo.learn.concurrency.designpattern.factory.abstractfactory;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class AKBullet implements Bullet {
    @Override
    public void load() {
        System.out.println("loading bullets with AK");
    }
}
