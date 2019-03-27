package com.ercargo.learn.concurrency.designpattern.proxy.service;

import com.ercargo.learn.concurrency.designpattern.proxy.service.IUserDao;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----保存用户数据----");
    }
}
