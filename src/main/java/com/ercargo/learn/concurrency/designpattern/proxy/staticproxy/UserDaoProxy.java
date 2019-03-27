package com.ercargo.learn.concurrency.designpattern.proxy.staticproxy;

import com.ercargo.learn.concurrency.designpattern.proxy.service.IUserDao;

/**
 * @author ercargo  on 2019/3/27
 * @DESCRIBE
 */
public class UserDaoProxy implements IUserDao {
    /**
     * 接收保存目标对象
     */
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    /**
     * 代理目标对象的save()方法
     */
    @Override
    public void save() {
        System.out.println("开始事务");
        target.save(); //执行目标对象的方法，就是调用目标对象的save()方法
        System.out.println("提交事务");
    }
}
