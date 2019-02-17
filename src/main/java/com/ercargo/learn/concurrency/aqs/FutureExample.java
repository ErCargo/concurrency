package com.ercargo.learn.concurrency.aqs;


import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.support.MethodInvokingRunnable;

import java.util.concurrent.*;

/**
 * @author ercargo  on 2019/2/17
 * @DESCRIBE
 */
@Slf4j
public class FutureExample {
    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {

            log.info("do something in callable");
            Thread.sleep(5000);
            return "done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future = exec.submit(new MyCallable());
        Thread.sleep(1000);
        log.info("do in main " );
        String result = future.get();

        log.info("result:{}", result);


    }
}
