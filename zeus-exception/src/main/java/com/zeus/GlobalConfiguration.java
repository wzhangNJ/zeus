/*
 * Copyright (C) 2017-2018 Qy All rights reserved
 * Author: wzhang
 * Date: 2018/12/26
 * Description:GlobalConfiguration.java
 */
package com.zeus;

import com.zeus.converter.GlobalResponseHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzhang
 */
@Configuration
public class GlobalConfiguration {

    @Bean
    public HttpMessageConverters messageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new GlobalResponseHttpMessageConverter());
        return new HttpMessageConverters(false, converters);
    }
}
