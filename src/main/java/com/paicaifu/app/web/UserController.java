package com.paicaifu.app.web;

import com.paicaifu.app.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Administrator on 2017/2/18.
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "获取User列表")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUser() {
        ArrayList<User> listUsers = new ArrayList<>(UserController.users.values());
        return listUsers;
    }

    @ApiOperation(value = "创建用户",notes = "根据user对象创建")
    @ApiImplicitParam(name = "user",value = "创建用户的对象")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String  addUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success";
    }

}
