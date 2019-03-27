package com.ercargo.learn.concurrency.concurrent.download.api;


/**
 * @author ercargo  on 2019/2/9
 * @DESCRIBE
 */
public interface ConnectionManager {
    /**
     * 给定一个url 打开一个连接
     * @param url
     * @return
     */
    Connection open(String url);
}
