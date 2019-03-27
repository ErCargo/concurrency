package com.ercargo.learn.concurrency.CallbackTest;

/**
 * @author ercargo  on 2019/3/26
 * @DESCRIBE 测试同步回调
 */
public class TestSyncPrinter {
    public static void main(String[] args) {
        People people = new People();
        Callback callback = new Callback() {
            @Override
            public void printFinished(String message) {
                System.out.println("打印机打印完回调" + message);
            }
        };

        System.out.println("需要打印的内容是----->");
        people.goToPrintSyn(callback, "打印一份简历");
        System.out.println("我在等待 打印机， 给我反馈");
    }
}
