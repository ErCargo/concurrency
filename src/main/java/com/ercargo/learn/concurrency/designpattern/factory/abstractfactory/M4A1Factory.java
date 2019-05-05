package com.ercargo.learn.concurrency.designpattern.factory.abstractfactory;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class M4A1Factory implements Factory {
    @Override
    public Gun productGun() {
        return new M4A1();
    }

    @Override
    public Bullet productBullet() {
        return new M4A1Bullet();
    }
}
