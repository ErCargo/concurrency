package com.ercargo.learn.concurrency.t;

import javax.sound.midi.Soundbank;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE 深入学习java 泛型
 */
public class TLearn {
    public static void main(String[] args) {
        Point<Integer> p = new Point<Integer>();
        p.setX(new Integer(100));
        System.out.println(p.getX());
        p.setY(new Integer(200));
        System.out.println(p.getY());



        Point<Float> p1 = new Point<>();
        p1.setY(new Float(100.00f));
        System.out.println(p1.getY());



        //定义多泛型的变量

        MorePoint<Integer, String , Float> m = new MorePoint<>();

        m.setX(new Integer(100));
        m.setY(new Integer(19));

        m.setUserName("aa");
        m.setPwd(123f);
    }



}
