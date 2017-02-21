package com.paicaifu.app.impl;

import com.paicaifu.app.domain.User;
import com.paicaifu.app.service.UserService;

import com.paicaifu.app.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by bayin on 2017/2/20.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有user数量
     *
     * @return
     */
    @Override
    public int getAllUser() {
        return jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    }

    /**
     * 创建user
     *
     * @param name
     * @param age
     * @return
     */
    @Override
    public int create(String name, String age) {
        int result = jdbcTemplate.update("insert into user(NAME , AGE) VALUES(?,?)", name, age);
        return result;
    }

    /**
     * 根据id删除user
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(long id) {
        int result = jdbcTemplate.update("DELETE FROM USER WHERE (id=?)", id);
        return result;
    }

    /**
     * 改user
     *
     * @param name
     * @param age
     * @return
     */
    @Override
    public int updateUser(String name, String age) {
        return jdbcTemplate.update("UPDATE USER SET (NAME ,age) VALUE (?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                if (!TextUtils.isEmpty(name))
                    ps.setString(1, name);
                if (!TextUtils.isEmpty(age))
                    ps.setString(2, age);
            }
        });
    }

    /**
     * 查询所有user
     *
     * @return
     */
    @Override
    public List<User> getAllUserList() {
        String sql = "select * from USER";
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                long id = resultSet.getLong(1);
                String age = resultSet.getString(2);
                String name = resultSet.getString(3);
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                return user;
            }
        });
        return list;
    }

    @Override
    public User queryUserByName(String name) {
        String sql = "select * from user where name=?";
        List<User> query = jdbcTemplate.query(sql, new Object[]{name}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user1 = new User();
                user1.setId(resultSet.getLong(1));
                user1.setAge(resultSet.getString(2));
                user1.setName(resultSet.getString(3));
                return user1;
            }
        });
        if (query != null && query.size() > 0)
            return query.get(0);
        else return null;
    }
}
