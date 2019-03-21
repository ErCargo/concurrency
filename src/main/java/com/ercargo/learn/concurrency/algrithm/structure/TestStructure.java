package com.ercargo.learn.concurrency.algrithm.structure;

/**
 * @author ercargo  on 2019/1/27
 * @DESCRIBE
 */
public class TestStructure {

    public static void main(String[] args) {
        EArrayList arr = new EArrayList();
        arr.add(0, 80);
     //   CyclicBarrier
    }


    public void wait(int s) {
        while (s <= 0) {
            //block()
        }
        s--;
    }


    public void signal(int s) {
        s++;
    }


    int mutex = 1; //
    int empty = 5;
    int full = 0;

    public void producer() {
        while (true) {
            wait(empty); // 4;
            wait(mutex); //  0
            //add to list
            signal(mutex); //1
            signal(full);  //1

        }
    }


    public void consumer() {
        while (true) {
            wait(full);   //0
            wait(mutex);  //-1
            //peek from list
            signal(mutex);  //0
            signal(empty); //5
        }
    }


}
