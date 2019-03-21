package com.ercargo.learn.concurrency.t.tfunctiontest;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE 泛型函数的定义及使用
 * 2种泛型函数： 静态方法
 *             普通方法
 *  在返回值前加上<T> 来表示泛型变量
 *
 */
public class StaticFans {

    public static <T> void staticMethod(T a) {
        System.out.println("aaa=" + a.toString());
    }


    public <T> void nonStaticMethod(T b) {
        System.out.println("bbb:=" + b.toString());
    }


    public static void main(String[] args) {
        /**
         * 像普通方法一样直接传值
         */
        StaticFans.staticMethod("测试静态方法的泛型使用方式1");
        /**
         * 建议使用这种方式，强制指定函数里所有用到的T类型都是String 的
         */
        StaticFans.<String>staticMethod("测试静态方法的泛型使用方式2");


        StaticFans non = new StaticFans();
        non.nonStaticMethod("测试非静态方法的使用方式");

        non.nonStaticMethod(new Integer(111));

    }

}
