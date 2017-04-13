package com.paicaifu.app.service;

import com.paicaifu.app.domain.primary.User;

import java.util.List;

/**
 * Created by bayin on 2017/2/20.
 */
public interface UserService {
    int create(String name,String age);
    int deleteById(long id);
    int getAllUser();
    int updateUser(String name, String age);
    List<User> getAllUserList();
    User queryUserByName(String name);
}
