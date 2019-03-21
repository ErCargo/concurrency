package com.ercargo.learn.concurrency.t.tfunctiontest;



/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class TestClassT {

/*
    public List<SuccessModel> parse(String resp){
        List<SuccessModel> list = JSON.parseArray(resp,SuccessModel.class);
        return list;

    }

    *//**
     *
     * @param resp
     * @param obj   用来装载类的class 对象
     * @param <T>
     * @return
     *//*
    public static <T> List<T> parseArray(String resp, Class<T> obj)  {
        List<T> modelList = JSON.parseArray(resp, obj);



        return modelList;
    }*/


    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 返回与给定的字符串名称相关联的类或者接口的Class对象
         */
        Class a = Class.forName("com.ercargo.learn.concurrency.t.tfunctiontest.TestClassT");

        //System.out.println(a.getClass()+","+a.getTypeName());

        Class[] aaa = a.getClasses();
        for(Class m :aaa){
            System.out.println(m.getName());
        }
    }




}
