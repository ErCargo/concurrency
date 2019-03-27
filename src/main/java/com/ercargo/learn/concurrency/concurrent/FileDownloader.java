package com.ercargo.learn.concurrency.concurrent;


import com.ercargo.learn.concurrency.concurrent.download.api.Connection;
import com.ercargo.learn.concurrency.concurrent.download.api.ConnectionManager;
import com.ercargo.learn.concurrency.concurrent.download.api.DownloadListener;

import java.util.concurrent.CyclicBarrier;

/**
 * @author ercargo  on 2019/2/9
 * @DESCRIBE
 */
public class FileDownloader {

    private String url;
    private String localFile;

    DownloadListener listener;

    ConnectionManager cm;
    private static final int DOWNLOAD_THREAD_NUM = 3;

    public FileDownloader(String url, String localFile) {
        this.url = url;
        this.localFile = localFile;
    }

    public void execute() {
        CyclicBarrier barrier = new CyclicBarrier(DOWNLOAD_THREAD_NUM, new Runnable() {
            @Override
            public void run() {
                listener.notifyFinished();
            }
        });

        Connection conn = null;
        conn = cm.open(this.url);
        int length = conn.getContentLength();
        creatPlaceHolderFile(this.localFile, length);

        /**
         * 给每个线程分配开始和结束位置
         */
        int[][] ranges = allocateDownloadRange(DOWNLOAD_THREAD_NUM, length);


    }

    private int[][] allocateDownloadRange(int downloadThreadNum, int length) {
        return new int[1][1];

    }

    private void creatPlaceHolderFile(String localFile, int length) {
    }

}

