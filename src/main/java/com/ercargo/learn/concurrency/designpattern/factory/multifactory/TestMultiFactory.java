package com.ercargo.learn.concurrency.designpattern.factory.multifactory;

import com.ercargo.learn.concurrency.designpattern.factory.product.Shape;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class TestMultiFactory {
    public static void main(String[] args) {
        Factory circleFactory = new CircleFactory();
        Shape circle = circleFactory.getShape();
        circle.draw();
    }

}
