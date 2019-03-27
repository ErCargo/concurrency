package com.ercargo.learn.concurrency.designpattern.factory.abstractfactory;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        Factory factory;
        Gun gun;
        Bullet bullet;


        factory = new AKFactory();
        bullet = factory.productBullet();
        bullet.load();
        gun = factory.productGun();
        gun.shooting();
    }
}
