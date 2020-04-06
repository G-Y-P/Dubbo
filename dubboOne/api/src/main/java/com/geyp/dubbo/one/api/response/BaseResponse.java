package com.geyp.dubbo.one.api.response;

import com.geyp.dubbo.one.api.enums.StatusCode;

import java.io.Serializable;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/27 0027 16:25
 * @description
 */
public class BaseResponse<T> implements Serializable{

    private Integer code;
    private String msg;
    private T data;

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public BaseResponse() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
