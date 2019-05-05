package com.ercargo.learn.concurrency.designpattern.factory.simplefactory;

import com.ercargo.learn.concurrency.designpattern.factory.product.Shape;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE 反射机制改善简单工厂模式
 * 但是每一次传入的都是产品类的全部路径， 可以通过反射+配置文件的形式改造
 *
 */
public class ShapeFactory2 {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;
        try {

            /**
             * 利用反射方式解决简单工厂每次新增产品都需要修改产品工厂的弊端
             */
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return obj;
    }
}
