package com.ercargo.learn.concurrency.concurrent.download.api;

import org.apache.coyote.http2.ConnectionException;

/**
 * @author ercargo  on 2019/2/9
 * @DESCRIBE
 */
public interface ConnectionManager {
    /**
     * 给定一个url 打开一个连接
     * @param url
     * @return
     * @throws ConnectionException
     */
    Connection open(String url) throws ConnectionException, ConnectionException;
}
