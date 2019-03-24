package com.ercargo.learn.concurrency.testmessage.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ercargo  on 2019/3/8
 * @DESCRIBE
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        /**
         * 创建一个连接工厂
         */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");

        factory.setHost("localhost");
        factory.setVirtualHost("/");

        /**
         * 根据工厂创建连接
         */
        Connection conn = factory.newConnection();
        /**
         * 连接中创建信道
         */
        Channel channel = conn.createChannel();

        /**
         * 声明交换器（channel中）
         */
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);
        /**
         * 指定路由键
         */
        String routingKey = "testRoutingKey";

        /**
         * 发送的消息
         */
        byte[] messageBodyBytes = "Hello rabbitmq".getBytes();

        /**
         * 发布消息（channel中）
         */
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
        channel.close();
        conn.close();

    }
}
