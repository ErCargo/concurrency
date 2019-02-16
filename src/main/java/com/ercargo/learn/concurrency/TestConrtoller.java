package com.ercargo.learn.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Controller
@Slf4j
public class TestConrtoller {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "Hello Concurrency!";
    }
}
