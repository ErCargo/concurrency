package com.ercargo.learn.concurrency.example.singletonExample;


import com.ercargo.learn.concurrency.annotation.NotRecommend;
import com.ercargo.learn.concurrency.annotation.NotThreadSafe;
import com.ercargo.learn.concurrency.annotation.ThreadSafe;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE 懒汉模式 单例的实例在第一次用的时候进行实例化创建
 */

/**
 * 不推荐！！！
 * 加了synchronized之后，同一段时间内只允许一个线程来访问来保证线程安全， 却带来了性能开销
 *
 */
@ThreadSafe
@NotRecommend
public class SingletonExample4 {
    /**
     * 私有构造函数
     */
    private SingletonExample4() {

    }

    /**
     * 单例对象  volatile + 双重检测机制  ->禁止指令重排
     */
    private volatile static SingletonExample4 instance = null;

    /**
     * 静态工厂方法
     * @return
     */
    public  static SingletonExample4 getInstance() {
        /**
         * 双重检测机制， 加同步锁
         * 双重同步锁单例模式
         *
         */
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }

        }
        return instance;
    }
}
