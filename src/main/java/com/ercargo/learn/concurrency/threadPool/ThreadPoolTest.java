package com.ercargo.learn.concurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ercargo  on 2019/3/19
 * @DESCRIBE
 */
public class ThreadPoolTest {
    /**
     * int corePoolSize       线程池的基本大小
     * int maximumPoolSize    线程池的最大线程数
     * long keepAliveTime     线程空闲后的存活时间
     * TimeUnit unit          时间单位
     * BlockingQueue<Runnable> workQueue    用于存放任务的阻塞队列
     * RejectExecutionHandler handler       当队列和最大线程池都满了之后的饱和策略
     *
     */
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }

}
