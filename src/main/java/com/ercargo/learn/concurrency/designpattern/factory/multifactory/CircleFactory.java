package com.ercargo.learn.concurrency.designpattern.factory.multifactory;

import com.ercargo.learn.concurrency.designpattern.factory.product.Circle;
import com.ercargo.learn.concurrency.designpattern.factory.product.Shape;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE 具体工厂角色， 实现抽象工厂接口，被应用程序调用， 创建某一种产品对象
 */
public class CircleFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
