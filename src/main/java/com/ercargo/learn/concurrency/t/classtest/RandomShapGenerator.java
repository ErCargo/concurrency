package com.ercargo.learn.concurrency.t.classtest;

import java.util.Random;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class RandomShapGenerator {

    private Random random = new Random(47);

    public Shape next(){
        switch (random.nextInt(3)){
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();

        }
    }
}
