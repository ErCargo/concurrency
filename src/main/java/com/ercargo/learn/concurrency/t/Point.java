package com.ercargo.learn.concurrency.t;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 * 1. 定义泛型： Point<T>, 类名后面加"<T>"  T 可以是任意大写字母，意义都相同
 * 2. 类中使用泛型，T表示派生自Object的任何类，String Integer等
 *    (1)定义变量： private T x;
 *    (2)作为返回值：T getX()
 *    (3)作为参数： setX(T x)
 * 3. 使用泛型类：
 * 4. 使用范型的优势: 不用强制转化
 *                  如果传入的类型不对， 就直接编译报错；
 * 5. 多泛型变量定义: Class MorePoint<T,U,E>
 *
 *
 *
 *     E  element  用于java collection  如： List<E>
 *     K,V   Map 键值对
 *     N  Number 数字
 *     T   Type 类型， String， Integer 等
 * 6. 泛型接口定义
 */
public class Point<T> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}
