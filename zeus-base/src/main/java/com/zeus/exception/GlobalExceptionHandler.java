/*
 * Copyright (C) 2015-2018 ihome All rights reserved
 * Author: wzhang
 * Date: 2018/2/28 0028
 * Description:GlobalExceptionHandler.java
 */
package com.zeus.exception;

import com.zeus.vo.ResultVO;
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
    /**
     *  处理自定义的异常
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResultVO customHandler(BaseException e){
        e.printStackTrace();
        ResultVO resultVo = new ResultVO();
        resultVo.setMsg(e.getMessage());
        resultVo.setCode(e.getErrorCode());
        resultVo.setSuccess(Boolean.FALSE);
        resultVo.setData(null);
        return resultVo;
    }

    /**
     *  其他未处理的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVO exceptionHandler(Exception e){
        e.printStackTrace();
        ResultVO resultVo = new ResultVO();
        resultVo.setMsg("系统异常");
        resultVo.setCode(-1);
        resultVo.setSuccess(Boolean.FALSE);
        resultVo.setData(null);
        return resultVo;
    }
}