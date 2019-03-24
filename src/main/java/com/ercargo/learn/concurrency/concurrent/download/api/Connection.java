package com.ercargo.learn.concurrency.concurrent.download.api;

import java.io.IOException;

/**
 * @author ercargo  on 2019/2/9
 * @DESCRIBE
 */
public interface Connection {
    byte[] read(int startPos, int endPos) throws IOException;
    int getContentLength();
    void close();

}
