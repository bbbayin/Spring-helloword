package com.paicaifu.app.service;

import com.paicaifu.app.domain.ResultBean;

/**
 * Created by bayin on 2017/2/24.
 */
public class ResultFactory {
    private static ResultFactory INSTANCE;
    private ResultFactory(){}

    public static ResultFactory getINSTANCE(){
        synchronized (ResultFactory.class){
            if (INSTANCE==null) INSTANCE = new ResultFactory();
        }
        return INSTANCE;
    }

    /**
     * @param code
     * @param msg
     * @param key
     * @param value
     * @param clazz
     * @return
     */
    public ResultBean generate(String code,String msg,String key,Object value,Class clazz){

        return null;
    }
}
