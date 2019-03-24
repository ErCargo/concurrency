package com.ercargo.learn.concurrency.concurrent.download.impl;




import com.ercargo.learn.concurrency.concurrent.download.api.Connection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

/**
 * @author ercargo  on 2019/2/9
 * @DESCRIBE
 */
class ConnectionImpl implements Connection {
    URL url;

    static final int BUFFER_SIZE = 1024;

    ConnectionImpl(String _url)  {
        try {
            url = new URL(_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] read(int startPos, int endPos) throws IOException {
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestProperty("Range","byte="+startPos+"-"+endPos);
        InputStream is = httpConn.getInputStream();

        //is.skip(startPos);
        byte[] buff = new byte[BUFFER_SIZE];

        //算出总共应读的长度
        int totalLen = endPos - startPos + 1;
        //内存中的输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        while (baos.size() < totalLen) {
            int len = is.read(buff);
            if (len < 0) {
                break;
            }
            baos.write(buff, 0, len);
        }

        if(baos.size()>totalLen){
            byte[] data = baos.toByteArray();
            return Arrays.copyOf(data,totalLen);
        }
        return baos.toByteArray();
    }

    @Override
    public int getContentLength() {
        URLConnection con;
        try {
            con = url.openConnection();
            return con.getContentLength();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public void close() {

    }
}
