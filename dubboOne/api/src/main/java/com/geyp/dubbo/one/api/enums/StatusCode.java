package com.geyp.dubbo.one.api.enums;

/**
 * @author GEYP
 * @version 1.0
 * @date 2020/3/27 0027 16:31
 * @description
 */
public enum StatusCode {

    Success(1,"成功"),
    Fail(-1,"失败"),
    InvalidParams(200,"无效参数"),
    ItemNotExist(201,"商品不存在");

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
