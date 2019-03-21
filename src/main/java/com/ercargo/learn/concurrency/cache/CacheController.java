package com.ercargo.learn.concurrency.cache;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author ercargo  on 2019/2/17
 * @DESCRIBE
 */
@Controller
@RequestMapping("/cache")
public class CacheController {

   @Resource
    private RedisClient redisClient;


    @RequestMapping("/set")
    @ResponseBody
    public String set(@RequestParam("k") String k, @RequestParam("v") String v) throws Exception {
        redisClient.set(k, v);
        return "success";
    }


    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam("k") String k) throws Exception {
        return redisClient.get(k);
    }
}
