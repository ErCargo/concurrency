package com.ercargo.learn.concurrency.CallbackTest;

/**
 * @author ercargo  on 2019/3/26
 * @DESCRIBE
 */
public class Printer {
    public void print(Callback callback, String text) {
        System.out.println("开始打印" + text);

        try {
            Thread.currentThread();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        callback.printFinished("结束打印" + text);
    }
}
