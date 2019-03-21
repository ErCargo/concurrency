package com.ercargo.learn.concurrency.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ercargo  on 2019/2/17
 * @DESCRIBE
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

    }
}
