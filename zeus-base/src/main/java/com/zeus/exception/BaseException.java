/*
 * Copyright (C) 2015-2018 ihome All rights reserved
 * Author: wzhang
 * Date: 2018/2/28 0028
 * Description:BaseException.java
 */
package com.zeus.exception;

/**
 * zeus封装基础自定义异常类
 * 项目中开发者自定义异常需要继承此基础异常类
 * 
 * @author wzhang
 */
public class BaseException extends RuntimeException{

    protected Integer errorCode ;
    
    protected Object data ;

    public BaseException(Integer errorCode, String message, Object data, Throwable e){
        super(message,e);
        this.errorCode = errorCode ;
        this.data = data ;
    }

    public BaseException(Integer errorCode, String message, Object data){
        this(errorCode,message,data,null);
    }

    public BaseException(Integer errorCode, String message){
        this(errorCode,message,null,null);
    }

    public BaseException(String message, Throwable e){
        this(null,message,null,e);
    }

    public BaseException(){

    }

    public BaseException(Throwable e){
        super(e);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
