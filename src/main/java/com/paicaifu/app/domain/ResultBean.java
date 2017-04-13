package com.paicaifu.app.domain;

import java.util.Map;

/**
 * Created by bayin on 2017/2/21.
 */
public class ResultBean<K, V> {
    private String code;
    private String msg;
    private Map<K, V> result;

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

    public Map<K, V> getResult() {
        return result;
    }

    public void setResult(Map<K, V> result) {
        this.result = result;
    }
}
