package com.ercargo.learn.concurrency.designpattern.factory.multifactory;

import com.ercargo.learn.concurrency.designpattern.factory.product.Shape;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE   工厂方法模式中的抽象工厂， 是核心，与业务无关，创建工厂类必须实现这个接口
 */
public interface Factory {
    Shape getShape();
}
