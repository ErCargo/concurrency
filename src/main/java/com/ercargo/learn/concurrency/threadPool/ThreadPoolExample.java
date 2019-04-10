package com.ercargo.learn.concurrency.threadPool;

import com.ercargo.learn.concurrency.CallableTest.MyCallable;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * @author ercargo  on 2019/2/17
 * @DESCRIBE
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future = exec.submit(new MyCallable());
        if(!future.isDone()){
            ConcurrentHashMap map = new ConcurrentHashMap();
            //LinkedList
            System.out.println("还没结束");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            exec.shutdown();
        }

    }
}
