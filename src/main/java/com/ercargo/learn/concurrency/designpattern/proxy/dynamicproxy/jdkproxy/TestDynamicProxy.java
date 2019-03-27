package com.ercargo.learn.concurrency.designpattern.proxy.dynamicproxy.jdkproxy;

import com.ercargo.learn.concurrency.designpattern.proxy.dynamicproxy.jdkproxy.ProxyFactory;
import com.ercargo.learn.concurrency.designpattern.proxy.service.IUserDao;
import com.ercargo.learn.concurrency.designpattern.proxy.service.UserDao;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        IUserDao target = new UserDao();

        /**
         * 测试类中输出原始的类型
         */
        System.out.println(target.getClass());

        /**
         * 获取动态代理对象
         */
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        /**
         * 内存中动态生成的对象
         */
        System.out.println(proxy.getClass());

        /**
         * 代理执行方法
         */
        proxy.save();
    }
}
