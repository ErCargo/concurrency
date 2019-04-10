package com.ercargo.learn.concurrency.CallableTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ercargo  on 2019/4/3
 * @DESCRIBE
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService cachedExecutor  = Executors.newCachedThreadPool();
    }
}
