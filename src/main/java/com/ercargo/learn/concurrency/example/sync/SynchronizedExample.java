package com.ercargo.learn.concurrency.example.sync;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Slf4j
public class SynchronizedExample {


    /**
     * 修饰一个代码块
     */
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1-{}", i);
            }
        }
    }


    /**
     * 同步方法
     */
    public synchronized void test2() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test2-{}", i);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample e  = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            e.test1();
        });

        executorService.execute(()->{
            e.test1();
        });


    }
}
