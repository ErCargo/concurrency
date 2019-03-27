package com.ercargo.learn.concurrency.designpattern.factory.simplefactory;

import com.ercargo.learn.concurrency.designpattern.factory.product.Circle;
import com.ercargo.learn.concurrency.designpattern.factory.product.Rectangle;
import com.ercargo.learn.concurrency.designpattern.factory.product.Shape;
import com.ercargo.learn.concurrency.designpattern.factory.product.Square;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 * 简单工厂方法， 如果需要新增一种产品的话，
 * 就需要改造工厂类中的getShape()方法， 不符合开放-封闭原则
 */
public class ShapeFactory {
    public static Shape getShape(String type) {
        if (type == null) {
            return null;
        }
        if (type.equals("Circle")) {
            return new Circle();
        }
        if (type.equals("Rectangle")) {
            return new Rectangle();
        }
        if (type.equals("Square")) {
            return new Square();
        }
        return null;
    }
}
