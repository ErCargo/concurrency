package com.ercargo.learn.concurrency.lock;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class LockTestDemo {
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        Thread t1 = new Thread(lockTest,"售票窗口1");
        Thread t2 = new Thread(lockTest,"售票窗口2");
        Thread t3 = new Thread(lockTest,"售票窗口3");


        t1.start();
        t2.start();
        t3.start();
    }
}
