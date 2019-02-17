package com.ercargo.learn.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Slf4j
public class CyclicBarrierTest2 {

    private static int threadCount = 20;
    private static CyclicBarrier barrier = new CyclicBarrier(5,()->{
        log.info("callback is running");
    });


    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        log.info("finished");
        exec.shutdown();


    }


    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info(" {} is ready ", threadNum);
        //Thread.sleep(1000);
        /*try{
            barrier.await(2000, TimeUnit.MILLISECONDS);
        }catch(BrokenBarrierException|TimeoutException ex){
            log.warn("BarrierException",ex);
        }
*/
        barrier.await();
        log.info("{} barrier continue",threadNum);
    }
}
