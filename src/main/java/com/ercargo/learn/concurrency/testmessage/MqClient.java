package com.ercargo.learn.concurrency.testmessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端与消息处理中心通信， 发送和接收消息
 * @author ercargo  on 2019/3/8
 * @DESCRIBE
 */
public class MqClient {
    public static void produce(String message) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println(message);
        out.flush();
    }

    public static String consume() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("CONSUME");
        out.flush();

        String message = in.readLine();
        return message;
    }
}
