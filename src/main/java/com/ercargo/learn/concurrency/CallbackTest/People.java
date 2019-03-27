package com.ercargo.learn.concurrency.CallbackTest;

/**
 * @author ercargo  on 2019/3/26
 * @DESCRIBE
 */
public class People {
    Printer printer = new Printer();

    /**
     * 同步回调
     * @param callback
     * @param text
     */
    public  void goToPrintSyn(Callback callback, String text){
        printer.print(callback,text);
    }



    public void goToPrintAsyn(Callback callback, String text){
        new Thread(new Runnable() {
            @Override
            public void run() {
                printer.print(callback,text);
            }
        }).start();
    }

}
