package com.ercargo.learn.concurrency.singleton;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class LazySingleton {

    private  static LazySingleton lazySingleton = null;

    private LazySingleton(){

    }

    public static synchronized LazySingleton getLazy(){
        if(lazySingleton ==null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


}
