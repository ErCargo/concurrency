package com.ercargo.learn.concurrency.example;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ercargo  on 2019/2/20
 * @DESCRIBE
 */
public class TestCallCount {
    AtomicInteger staticCount = new AtomicInteger();

    public static void main(String[] args) {
        TestCallCount call = new TestCallCount();
        System.out.println(call.count());
    }


    public AtomicInteger count(){
        for(int i = 0 ; i<1000;i++){
            foo();
            //System.out.println("foo 被调用");
        }
        return staticCount;
    }

    public void foo(){
        staticCount.incrementAndGet();
        //System.out.println("调用foo方法");
    }

}
