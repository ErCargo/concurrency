package com.ercargo.learn.concurrency.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author ercargo  on 2019/2/17
 * @DESCRIBE
 */
@Configuration
public class RedisConfig {
    @Bean(name = "redisPool")
    public JedisPool jedisPool(@Value("${jedis.host}") String host,
                               @Value("${jedis.port}") int port) {

        return new JedisPool(host, port);
    }

}
