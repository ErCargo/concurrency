package com.ercargo.learn.concurrency.testmessage;

/**
 * @author ercargo  on 2019/3/8
 * @DESCRIBE
 */
public class ConsumerClient {
    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();
        String message = client.consume();
        System.out.println("获取的消息为："+message);
    }

}
