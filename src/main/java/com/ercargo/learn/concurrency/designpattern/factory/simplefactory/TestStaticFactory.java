package com.ercargo.learn.concurrency.designpattern.factory.simplefactory;

import com.ercargo.learn.concurrency.designpattern.factory.product.Shape;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class TestStaticFactory {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("Circle");
        circle.draw();

        Shape rectangle = ShapeFactory.getShape("Rectangle");
        rectangle.draw();

        Shape square = ShapeFactory.getShape("Square");
        square.draw();
    }
}
