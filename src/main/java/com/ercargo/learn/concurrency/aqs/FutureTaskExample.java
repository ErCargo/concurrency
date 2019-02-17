package com.ercargo.learn.concurrency.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author ercargo  on 2019/2/17
 * @DESCRIBE
 */
@Slf4j
public class FutureTaskExample {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable() {

            @Override
            public Object call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "done";
            }
        });

        new Thread(futureTask).start();
        log.info("main 方法执行。。。。。。");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result:{}", result);

    }
}
