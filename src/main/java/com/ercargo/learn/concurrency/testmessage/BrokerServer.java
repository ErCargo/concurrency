package com.ercargo.learn.concurrency.testmessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 消息中心对外提供的服务
 * 需要通过线程的方式将应用启动起来，服务器与客户端之间需要进行网络通信（Socket）
 * @author ercargo  on 2019/3/8
 * @DESCRIBE
 */
public class BrokerServer implements Runnable {

    public static int SERVICE_PORT = 9999;
    private final Socket socket;

    public BrokerServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while (true) {
                String str = in.readLine();
                /**
                 * 如果没读到continue
                 */
                if (str == null) {
                    continue;
                }

                /**
                 * 监听到
                 */
                System.out.println("接收到数据" + str);
                /**
                 * 并且监听到的是"CONSUME"====》 说明实现消费者
                 */
                if(str.equals("CONSUME")){
                    String message = Broker.consume();
                    out.println(message);
                    out.flush();
                } else{
                    /**
                     * 生产者
                     */
                    Broker.produce(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(SERVICE_PORT);
        while(true){
            BrokerServer brokerServer = new BrokerServer(serverSocket.accept()); //阻塞监听
            /**
             * 创建，就绪，运行，阻塞， 死亡
             * start()启动线程,线程处于就绪状态， 并没有运行， Thread 类调用run() 来完成其运行操作的，
             * 无需等待run()方法执行完毕， 就可以直接继续执行下面的代码
             */
            new Thread(brokerServer).start();
        }
    }


}
