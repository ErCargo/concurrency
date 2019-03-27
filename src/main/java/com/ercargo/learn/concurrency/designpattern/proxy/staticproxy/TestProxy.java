package com.ercargo.learn.concurrency.designpattern.proxy.staticproxy;

import com.ercargo.learn.concurrency.designpattern.proxy.service.UserDao;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class TestProxy {

    public static void main(String[] args) {
        /**
         * 目标对象
         */
        UserDao target = new UserDao();
        /**
         * 代理对象， 把目标对象传给扩展对象，建立代理关系
         */
        UserDaoProxy proxy  = new UserDaoProxy(target);

        /**
         * 执行代理的方法
         */
        proxy.save();
    }
}
