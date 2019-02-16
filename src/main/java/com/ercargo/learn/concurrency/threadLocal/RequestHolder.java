package com.ercargo.learn.concurrency.threadLocal;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE 线程封闭方法：
 * 1. AdHoc
 * 2. 堆栈封闭(局部变量，无并发问题)
 * 多个线程执行一个方法的时候， 方法中的局部变量都会被拷贝一份到线程的栈中，
 * 局部变量不是被线程共享的， 所以就不会出现线程安全问题
 * 3. ThreadLocal
 * 内部维护了一个Map , key 是线程名称， value是线程的对象
 * 每个请求都是一个线程， ThreadLocal实现了线程间隔离，
 */

/**
 * 线程封闭方法：
 * 1. AdHoc
 * 2. 堆栈封闭(局部变量，无并发问题)
 *    多个线程执行一个方法的时候， 方法中的局部变量都会被拷贝一份到线程的栈中，
 *    局部变量不是被线程共享的， 所以就不会出现线程安全问题
 * 3. ThreadLocal
 *    内部维护了一个Map , key 是线程名称， value是线程的对象
 *    每个请求都是一个线程， ThreadLocal实现了线程间隔离，
 *
 */

import java.util.concurrent.ConcurrentHashMap;

/**
 * 存储需要绑定到线程上的信息
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();


    /**
     * 请求进入到后端服务器， 还有没有实际处理时，把相关信息写入ThreadLocal
     * @param id
     */
    public static void add(Long id) {
        /**
         * 默认去除当前线程id， 放入map (线程，id)
         */
        requestHolder.set(id);

        StringBuilder sb = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();


    }

    public static Long getId() {
        return requestHolder.get();
    }

    /**
     * 不做移除的话， 会造成内存泄漏， 这个类会伴随着项目，重启才会释放
     *
     * 接口真正处理完后再调用
     */
    public static void remove() {
        requestHolder.remove();
    }


}
