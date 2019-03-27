package com.ercargo.learn.concurrency.designpattern.factory.abstractfactory;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE  具体工厂 生产AK的枪 和AK的子弹的工厂
 */
public class AKFactory implements Factory {
    @Override
    public Gun productGun() {
        return new AK();
    }

    @Override
    public Bullet productBullet() {
        return new AKBullet();
    }
}
