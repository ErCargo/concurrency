package com.ercargo.learn.concurrency.designpattern.factory.abstractfactory;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE 工厂接口
 */
public interface Factory {

    Gun productGun();

    Bullet productBullet();
}
