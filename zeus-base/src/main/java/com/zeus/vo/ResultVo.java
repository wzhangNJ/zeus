/*
 * Copyright (C) 2015-2018 ihome All rights reserved
 * Author: wzhang
 * Date: 2018/2/28 0028
 * Description:ResultVo.java
 */
package com.zeus.vo;

/**
 * 统一处理返回对象
 *
 * @author wzhang
 */
public class ResultVo<T> {

    private T data;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 代码
     */
    private Integer code;

    /**
     * 是否成功
     */
    private boolean success;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
