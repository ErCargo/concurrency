package com.ercargo.learn.concurrency.CallableTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ercargo  on 2019/4/3
 * @DESCRIBE
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        Thread t1 = new Thread(task);
        t1.start();
        if(!task.isDone()){
            System.out.println("请等一下");
        }

        System.out.println("任务完成,返回："+task.get());

        int i = 1;
        i = --i;
        System.out.println(i);
    }
}
