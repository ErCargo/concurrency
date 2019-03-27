package com.ercargo.learn.concurrency.designpattern.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE 创建一个动态代理对象，动态代理对象不需要实现接口， 但需要执行接口类型
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }


    public Object getProxyInstance() {
        /**
         * 1. ClassLoader 指定需要被代理的目标对象的ClassLoader
         * 2. Class[] interfaces 指定需要实现的接口数组
         * 3. 调用处理器，执行目标对象的方法， 会触发调用处理器的invoke()方法， 从而把当前执行目标对象的方法作为参数传入
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始事务。。。");
                Object returnValue = method.invoke(target, args);
                System.out.println("提交事务。。。。");
                return returnValue;
            }
        });
    }
}
