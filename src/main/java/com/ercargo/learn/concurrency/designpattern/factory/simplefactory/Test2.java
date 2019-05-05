package com.ercargo.learn.concurrency.designpattern.factory.simplefactory;

import com.ercargo.learn.concurrency.designpattern.factory.product.Circle;
import com.ercargo.learn.concurrency.designpattern.factory.product.Rectangle;
import com.ercargo.learn.concurrency.designpattern.factory.product.Square;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class Test2 {
    public static void main(String[] args) {
        Circle circle = (Circle) ShapeFactory2.getClass(Circle.class);
        circle.draw();
        Rectangle rectangle = (Rectangle) ShapeFactory2.getClass(Rectangle.class);
        rectangle.draw();
        Square square = (Square) ShapeFactory2.getClass(Square.class);
        square.draw();


    }
}
