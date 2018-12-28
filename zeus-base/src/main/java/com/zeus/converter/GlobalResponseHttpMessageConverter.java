/*
 * Copyright (C) 2017-2018 Qy All rights reserved
 * Author: wzhang
 * Date: 2018/12/26
 * Description:GlobalResponseHttpMessageConverter.java
 */
package com.zeus.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zeus.vo.ResultVO;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author wzhang
 */
public class GlobalResponseHttpMessageConverter extends AbstractHttpMessageConverter {

    public final static Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Charset charset = DEFAULT_CHARSET;

    private SerializerFeature[] features = new SerializerFeature[0];


    public GlobalResponseHttpMessageConverter() {
        super(new MediaType("application", "json", DEFAULT_CHARSET), MediaType.ALL);
    }
    
    @Override
    protected boolean supports(Class clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(inputMessage.getBody(), clazz);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String text = "";
        if(o instanceof ResultVO){
            text = JSON.toJSONString(o, features);
        }else {
            ResultVO resultVo = new ResultVO();
            resultVo.setMsg("success");
            resultVo.setCode(1);
            resultVo.setSuccess(Boolean.TRUE);
            resultVo.setData(o);
             text = JSON.toJSONString(resultVo, features);
        }
        byte[] bytes = text.getBytes(charset);
        outputMessage.getBody().write(bytes);
    }
}
