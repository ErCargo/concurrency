package com.ercargo.learn.concurrency.testmessage;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 消息中心
 * @author ercargo  on 2019/3/8
 * @DESCRIBE
 */
public class Broker {
    private final static int MAX_VALUE = 10;
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(MAX_VALUE);

    public static void produce(String msg) {
        /**
         * 判断插入队列尾部是否成功
         */
        if (messageQueue.offer(msg)) {
            System.out.println("生产消息：" + msg + "当前消息大小：" + messageQueue.size());
        } else {
            /**
             * 插入队尾失败， 说明队列已经满了
             */
            System.out.println("满了");
        }
        System.out.println("==========================");
    }


    public static String consume() {
        /**
         * 从消息队列中取出头部的元素
         */
        String msg = messageQueue.poll();
        if (msg != null) {
            System.out.println("消费消息" + msg + "当前消息队列大小：" + messageQueue.size());
        } else {
            System.out.println("空了");
        }
        System.out.println("==========================");
        return msg;
    }
}
