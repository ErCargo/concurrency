package com.ercargo.learn.concurrency.concurrent.download.impl;


import com.ercargo.learn.concurrency.concurrent.download.api.Connection;
import com.ercargo.learn.concurrency.concurrent.download.api.ConnectionManager;

/**
 * @author ercargo  on 2019/2/9
 * @DESCRIBE
 */
public class ConnectionManagerImpl implements ConnectionManager {
    @Override
    public Connection open(String url) {
        return new ConnectionImpl(url);

    }
}
