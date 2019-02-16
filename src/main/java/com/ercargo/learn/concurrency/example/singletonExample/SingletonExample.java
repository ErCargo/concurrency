package com.ercargo.learn.concurrency.example.singletonExample;

import com.ercargo.learn.concurrency.annotation.NotThreadSafe;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE   懒汉模式 单例的实例在第一次用的时候进行实例化创建
 */
@NotThreadSafe
public class SingletonExample {
    /**
     * 私有构造函数
     */
    private SingletonExample(){

    }

    /**
     * 单例对象
     */
    private static SingletonExample instance = null;


    /**
     * 静态工厂方法
     * @return
     */
    public static  SingletonExample getInstance(){
        if(instance == null){
            instance = new SingletonExample();
        }
        return instance;
    }
}
