package com.ercargo.learn.concurrency.t.tfunctiontest;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author ercargo  on 2019/3/20
 * @DESCRIBE
 */
public class ReturnValue {
    public static <T> List<T> parseArray(String resp, Class<T> object) {
        List<T> modelList = JSON.parseArray(resp, object);
        return modelList;
    }


    public static void main(String[] args) {
        ReturnValue rv = new ReturnValue();
        //List<ReturnValue> list = rv.parseArray("aa", ReturnValue.class);


        /**
         * 使用Class<T> 传递Class对象
         *
         */

    }
}
