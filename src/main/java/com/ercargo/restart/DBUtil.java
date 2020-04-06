package com.ercargo.restart;

import com.ercargo.learn.concurrency.concurrent.download.api.Connection;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ercargo  on 2020/3/31
 * @DESCRIBE
 */
public class DBUtil {
    // 数据库连接池
    private static BasicDataSource source;

    private static ThreadLocal<Connection> local;

    static {
        try{
            Properties properties = new Properties();

            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
