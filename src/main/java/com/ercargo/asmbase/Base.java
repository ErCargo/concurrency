package com.ercargo.asmbase;

import java.lang.management.ManagementFactory;

/**
 * @author ercargo  on 2020/4/5
 * @DESCRIBE
 */
public class Base {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];

        System.out.println("pid:" + s);

        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                break;
            }

            process();
        }
    }

    public static void process() {
        System.out.println("process");
    }

    static {
        System.out.println("静态代码块被执行（类变量准备）");
    }
}
