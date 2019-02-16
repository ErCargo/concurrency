package com.ercargo.learn.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Slf4j
public class CountDownLatchTest2 {

    private static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);


        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;

            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await(10, TimeUnit.MILLISECONDS);

        log.info("finished");
        exec.shutdown();
    }


    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("{}", threadNum);
        //Thread.sleep(100);
    }
}
