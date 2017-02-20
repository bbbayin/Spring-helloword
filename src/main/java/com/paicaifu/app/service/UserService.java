package com.paicaifu.app.service;

/**
 * Created by bayin on 2017/2/20.
 */
public interface UserService {
    int create(String name,String age);
    int deleteById(long id);
}
