package com.ercargo.learn.concurrency.test;

/**
 * @author ercargo  on 2019/5/7
 * @DESCRIBE
 */
public interface BInterface {

    default void doAnother(){
        System.out.println("test multi inher");
    }
}
