package com.ercargo.learn.concurrency.example.atomic;

import com.ercargo.learn.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 {
    /***
     * AtomicReference CAS 的ABA问题
     * ABA问题是指在CAS操作时， 其他线程将变量的值从A 改成了B， 但是又改回了A；
     * 本线程  使用期望值A与当前变量比较的时候发现A变量没有变，于是CAS又将A值进行了交换操作
     * 其实该值已经被其他线程改变过；
     *
     *
     *
     * 解决思路：
     * 每次变量更新的时候把变量的版本号加1 ，
     * 只要变量被某个线程修改过，该变量对应的版本号就会发生递增变化，从而解决了ABA问题
     */


    /**
     * AtomicLongArray 维护的是一个数组
     */


    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    //请求总数
    public static int clientTotal = 5000;
    //同事并发执行的线程数
    public static int threadTotal = 200;
    
    public static void main(String[] args) throws Exception{
        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //计数器闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);


        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //引入信号量， 判读当前县线程是否允许被执行；达到一定的并发数， add()会阻塞；acquire 能返回值时 ， add()才会执行，执行完后要释放
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception" + e);
                    e.printStackTrace();
                }
                //每执行完一次，计数值减1
                countDownLatch.countDown();

            });
        }
        countDownLatch.await(); //保证之前的线程都运行完了，再计数
        executorService.shutdown();
        //所有线程执行完后打印计数值
        log.info("isHappened{}", isHappened.get());
    }

    private static void test() {
        /**
         * 原子性操作， 从false 到true的操作只会执行一次，之后的所有4999操作都不会被执行
         * 如何让某一段代码只执行一次！！！！
         */
        if(isHappened.compareAndSet(false,true)){
            log.info("isHappened execute");
        }
    }


}
