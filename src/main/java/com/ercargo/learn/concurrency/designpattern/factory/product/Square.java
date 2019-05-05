package com.ercargo.learn.concurrency.designpattern.factory.product;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE 简单工厂模式中的具体产品
 */
public class Square implements Shape {
    public Square() {
        System.out.println("Square");
    }

    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}
