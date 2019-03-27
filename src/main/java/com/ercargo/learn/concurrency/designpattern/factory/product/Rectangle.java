package com.ercargo.learn.concurrency.designpattern.factory.product;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE 简单工厂模式中的具体产品
 */
public class Rectangle implements Shape {
    public Rectangle() {
        System.out.println("Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("draw Rectangle");
    }
}
