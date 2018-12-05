package com.worth.springdemo.exception;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 2018/11/30 16:43
 */
public class BusinessException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public BusinessException(String msg){
        super(msg);
        this.msg = msg;
    }

    public BusinessException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BusinessException(int code,String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BusinessException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
