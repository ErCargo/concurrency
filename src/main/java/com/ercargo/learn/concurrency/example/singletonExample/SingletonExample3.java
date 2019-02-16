package com.ercargo.learn.concurrency.example.singletonExample;


import com.ercargo.learn.concurrency.annotation.NotRecommend;
import com.ercargo.learn.concurrency.annotation.ThreadSafe;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE   懒汉模式 单例的实例在第一次用的时候进行实例化创建
 */

/**
 * 不推荐！！！
 * 加了synchronized之后，同一段时间内只允许一个线程来访问来保证线程安全， 却带来了性能开销
 *
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    /**
     * 私有构造函数
     */
    private SingletonExample3(){

    }

    /**
     * 单例对象
     */
    private static SingletonExample3 instance = null;


    /**
     * 静态工厂方法
     * @return
     */
    public  static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
