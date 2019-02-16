package com.ercargo.learn.concurrency.example.count;

import com.ercargo.learn.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTestExample1 {
    //请求总数
    public static int clientTotal = 5000;
    //同事并发执行的线程数
    public static int threadTotal = 200;
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

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
                    add();
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
        log.info("count{}", count);

    }

    private static void add() {
        count++;
    }
}
