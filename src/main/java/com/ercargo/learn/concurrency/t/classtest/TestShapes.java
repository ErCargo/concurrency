package com.ercargo.learn.concurrency.t.classtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class TestShapes {

    private static RandomShapGenerator rand = new RandomShapGenerator();

    public static void main(String[] args) {
        /*List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());

        *//*List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle());*//*
        for (Shape shape : shapeList) {
            shape.draw();
        }*/

        Shape[] s = new Shape[9];

        for (int i = 0; i < s.length; i++) {
            s[i]  = rand.next();

        }
        for (Shape shape : s) {
            shape.draw();
        }
    }
}
