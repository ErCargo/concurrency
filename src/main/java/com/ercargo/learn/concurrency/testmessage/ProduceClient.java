package com.ercargo.learn.concurrency.testmessage;


/**
 * @author ercargo  on 2019/3/8
 * @DESCRIBE
 */
public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient mqClient  = new MqClient();
        mqClient.produce("Hello world");
    }
}
