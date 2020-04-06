package com.ercargo.restart;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ercargo  on 2020/3/31
 * @DESCRIBE
 */
public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rt = Class.forName("com.ercargo.restart.RobotTest");
        // 创建实例
        RobotTest r = (RobotTest) rt.newInstance();
        System.out.println("Class name is" + rt.getName());
        // getDeclaredMethod 获取所有声明的方法，但不能获取继承的方法和实现的接口的方法
        Method getHello = rt.getDeclaredMethod("throwHello", String.class);
        // 私有方法
        getHello.setAccessible(true);

        Object str = getHello.invoke(r, "World");
        System.out.println("success reflect getHello method " + str);

        /** ---- 另一种方法 ---- **/
        // getMethod() 只能获取公共方法， 也能获取继承类的公用方法，和接口实现的公用方法
        Method sayHi = rt.getMethod("sayHi", String.class);
        sayHi.invoke(r,"Welcome");

        // 获取私有类型的属性
        Field field = rt.getDeclaredField("name");
        field.setAccessible(true);
        field.set(r, "WWWWWWorld");
        sayHi.invoke(r, "Welcome  ");

        System.out.println("aaaa"+System.getProperty("java.ext.dirs"));

        System.out.println( "bbb   "+ System.getProperty("java.class.path"));
    }
}
