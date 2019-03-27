package com.ercargo.learn.concurrency.CallbackTest;

/**
 * @author ercargo  on 2019/3/26
 * @DESCRIBE
 */
public class TestAsynPrinter {
    public static void main(String[] args) {
        People people   = new People();
        Callback callback = new Callback() {
            @Override
            public void printFinished(String message) {
                System.out.println("打印机回调给我的消息是："+ message);
            }
        };

        //System.out.println("");
        people.goToPrintAsyn(callback, "打印一份简历");
        System.out.println("我在等待 打印机 给我反馈");
    }
}
