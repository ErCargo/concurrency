package com.ercargo.learn.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Slf4j
public class SemaphoreTest {

    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        //给定允许的并发数
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    /**
                     * 拿到一个许可
                     */
                    semaphore.acquire(3);
                    test(threadNum);
                    /**
                     * 执行完后释放许可
                     */
                    semaphore.release(3);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        log.info("finished");
        exec.shutdown();
    }


    private static void test(int threadNum) throws Exception {
        //Thread.sleep(100);
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
