package com.zeus.controller;

import com.zeus.exception.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String sayHello() {
        if(true)
//          throw new BaseException(-1,"业务数据异常");
            throw new RuntimeException();
        return "Hello,World!";
    }
}
