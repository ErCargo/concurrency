package com.ercargo.asmbase;

/**
 * @author ercargo  on 2020/4/5
 * @DESCRIBE
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader c = Base.class.getClassLoader();
        Class c = Class.forName("com.ercargo.asmbase.Base");
    }
}