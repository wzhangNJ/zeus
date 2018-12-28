package com.zeus.controller;

import com.zeus.exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "测试swagger", description = "测试swagger", tags = {"HelloWorldController"})
@RestController
public class HelloWorldController {

    @ApiOperation(value = "无参接口", notes = "无参接口")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String sayHello() {
//        if(true)
//          throw new BaseException(-1,"业务数据异常");
//            throw new RuntimeException();
        return "Hello,World!";
    }

    @ApiOperation(value = "有参接口", notes = "有参接口")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Test test(@RequestBody Test test) {
        Test t = new Test();
        t.setName("tom");
        return t;
    }
}

