package com.ercargo.learn.concurrency.designpattern.proxy.dynamicproxy.cglibproxy;

import com.ercargo.learn.concurrency.designpattern.proxy.service.UserDao;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        UserDao target = new UserDao();

        UserDao proxy = (UserDao) new CglibProxyFactory(target).getProxyInstance();

        proxy.save();

    }
}
