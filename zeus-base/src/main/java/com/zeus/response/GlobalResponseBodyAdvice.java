/*
 * Copyright (C) 2017-2018 Qy All rights reserved
 * Author: wzhang
 * Date: 2018/12/26
 * Description:ZeusResponseBodyAdvice.java
 */
package com.zeus.response;

import com.zeus.vo.ResultVO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author wzhang
 */
//@ControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public ResultVO beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ResultVO resultVo = new ResultVO();
        resultVo.setMsg("success");
        resultVo.setCode(1);
        resultVo.setSuccess(Boolean.TRUE);
        resultVo.setData(o);
        return resultVo;
    }

}
