/*
 * Copyright (C) 2015-2018 ihome All rights reserved
 * Author: wzhang
 * Date: 2018/2/28 0028
 * Description:GlobalExceptionHandler.java
 */
package com.zeus;

import com.zeus.exception.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理，捕获所有Controller中抛出的异常。
 *
 * @author wzhang
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //处理自定义的异常
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResultVo customHandler(BaseException e){
        e.printStackTrace();
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(e.getErrorCode());
        resultVo.setMsg(e.getMessage());
        resultVo.setSuccess(Boolean.FALSE);
        resultVo.setData(null);
        return resultVo;
    }
    
    //其他未处理的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo exceptionHandler(Exception e){
        e.printStackTrace();
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(-1);
        resultVo.setMsg("系统异常");
        resultVo.setSuccess(Boolean.FALSE);
        resultVo.setData(null);
        return resultVo;
    }
}