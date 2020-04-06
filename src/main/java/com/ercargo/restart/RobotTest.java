package com.ercargo.restart;

/**
 * @author ercargo  on 2020/3/31
 * @DESCRIBE
 */
public class RobotTest {
    private String name;

    public void sayHi(String helloSentence){
        System.out.println(helloSentence + "" + name);
    }

    private String throwHello(String tag){
        return "Hello" + tag;
    }
}
