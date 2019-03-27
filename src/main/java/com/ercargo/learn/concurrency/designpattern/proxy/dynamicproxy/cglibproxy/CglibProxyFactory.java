package com.ercargo.learn.concurrency.designpattern.proxy.dynamicproxy.cglibproxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象创建一个代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        /**
         * 设置父类
         */
        enhancer.setSuperclass(target.getClass());
        /**
         * 设置回调函数
         */
        enhancer.setCallback(this);

        /**
         * 创建子类（代理对象）
         */
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务");
        Object returnValue = method.invoke(target, objects);
        System.out.println("提交事务");
        return returnValue;
    }
}
