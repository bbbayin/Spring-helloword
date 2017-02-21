package com.paicaifu.app.domain;

/**
 * Created by bayin on 2017/2/21.
 */
public class ResultBean<T> {
    private String code;
    private String msg;
    private  T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
