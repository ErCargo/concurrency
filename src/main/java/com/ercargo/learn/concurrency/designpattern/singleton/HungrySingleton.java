package com.ercargo.learn.concurrency.designpattern.singleton;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class HungrySingleton {

    private static final HungrySingleton hungry = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getHungry(){
        return hungry;
    }



}
