package com.ercargo.restart;

/**
 * @author ercargo  on 2020/4/4
 * @DESCRIBE
 */
public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyCLassLoader loader = new MyCLassLoader("/Users/ercargo/Desktop/","xxx");
        Class c = loader.loadClass("Walle");
        System.out.println(c.getClassLoader());
        c.newInstance();
    }

}
