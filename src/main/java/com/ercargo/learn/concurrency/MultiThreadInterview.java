package com.ercargo.learn.concurrency;

import java.io.IOException;

/**
 * @author ercargo  on 2019/4/10
 * @DESCRIBE
 */
public class MultiThreadInterview{


    /**
     * 创建线程只有1种方法， 运行线程 会有2种方法
     *
     * 1. 传Runnable,
     * @Override
        public void run() {
            if (target != null) {
              target.run();
         }
       }
     * target!= null, 调用run()
     *
     * 2. 扩展Thread ,通过多态的方式， 覆盖父类实现， 调用super.run()
     * @param args
     *
     */
    public static void main(String[] args) throws IOException {
       /* Thread t = new Thread(()->{
        },"子线程");*/


        /**
         * 创建线程
         */
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("calc");
        process.exitValue();
    }


    public static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}
