package com.paicaifu.app;

import com.paicaifu.app.domain.User;
import com.paicaifu.app.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Administrator on 2017/2/18.
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
    @Autowired
    private UserService userImpl ;

    @ApiOperation(value = "获取User列表")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUser() {
        ArrayList<User> listUsers = new ArrayList<>(UserController.users.values());
        return listUsers;
    }

    @ApiOperation(value = "创建用户", notes = "根据user对象创建")
    @ApiImplicitParam(name = "user", value = "创建用户的对象")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(@RequestParam("name")String name,@RequestParam("age")String age) throws Exception{
        int result = userImpl.create(name, age);
        if (result > 0)
            return "success";
        else
            return "failure";
    }

}
