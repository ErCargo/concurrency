package com.ercargo.learn.concurrency.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class LockTest implements Runnable {
    private int tickets = 10;
    private Lock lock = new ReentrantLock();

    //ConcurrentHashMap

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在售出第" + (tickets--) + "张票");
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
