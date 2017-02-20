package com.paicaifu.app.impl;

import com.paicaifu.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by bayin on 2017/2/20.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(String name, String age) {


        int result = jdbcTemplate.update("insert into user(NAME , AGE) VALUES(?,?)", name, age);
        return result;
    }

    @Override
    public int deleteById(long id) {
        int result = jdbcTemplate.update("DELETE FROM USER WHERE (id=?)", id);
        return result;
    }
}
