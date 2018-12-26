package com.zeus.controller;

import com.zeus.exception.BaseException;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String sayHello() {
        if(true)
          throw new BaseException(-1,"业务数据异常");
//            throw new RuntimeException();
        return "Hello,World!";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Test test(@RequestBody Test test) {
        return new Test("tom");
    }
}

