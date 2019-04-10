package com.ercargo.learn.concurrency.CallableTest;

import java.util.concurrent.Callable;

/**
 * @author ercargo  on 2019/4/3
 * @DESCRIBE 获取线程的返回值
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "aaaaa";
        System.out.println("准备。。。。。");
        Thread.currentThread().sleep(5000);
        System.out.println("任务完成");
        return value;
    }
}
