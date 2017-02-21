package com.paicaifu.app.web;

import com.paicaifu.app.domain.ResultBean;
import com.paicaifu.app.domain.User;
import com.paicaifu.app.domain.UserRepository;
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
    private UserService userImpl;
    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "获取User列表")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUser() {
        ArrayList<User> listUsers = new ArrayList<>(UserController.users.values());
        return listUsers;
    }

    @ApiOperation(value = "创建用户", notes = "根据user对象创建")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(@RequestParam("name") String name, @RequestParam("age") String age) throws Exception {
        int result = userImpl.create(name, age);
        if (result > 0)
            return "success";
        else
            return "failure";
    }


    @ApiOperation(value = "查询用户数量", notes = "")
    @RequestMapping(value = "/usercount", method = RequestMethod.GET)
    public ResultBean<Map<String, Integer>> getUserCount() {
        ResultBean<Map<String, Integer>> resultBean = new ResultBean<>();
        resultBean.setCode("0000");
        resultBean.setMsg("查询成功");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("userCount", userImpl.getAllUser());
        resultBean.setResult(map);
        return resultBean;
    }

    @ApiOperation(value = "获取所有user信息")
    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public ResultBean<Map<String, List<User>>> getAllUserList() throws Exception {
        List<User> allUserList = userImpl.getAllUserList();
        ResultBean<Map<String, List<User>>> resultBean = new ResultBean<>();
        resultBean.setMsg("查询成功");
        resultBean.setCode("0000");
        HashMap<String, List<User>> map = new HashMap<>();
        map.put("userlist", allUserList);
        resultBean.setResult(map);
        return resultBean;
    }

    @ApiOperation(value = "通过name查询user信息")
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public ResultBean<Map<String, User>> getUserByName(@RequestParam(value = "name") String name) throws Exception {
        ResultBean<Map<String, User>> bean = new ResultBean<>();
        User user = userImpl.queryUserByName(name);
        HashMap<String, User> map = new HashMap<>();
        if (user != null)
            map.put("userinfo", user);
        bean.setResult(map);
        bean.setCode("0000");
        bean.setMsg("查询成功");
        return bean;
    }

    /*--------jpa测试--------*/
    @ApiOperation(value = "创建用户-jpa")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age) {
        userRepository.save(new User(name, age));
        return "test";
    }

    @ApiOperation(value = "根据name查找user-jpa")
    @RequestMapping(value = "/finduser",method = RequestMethod.GET)
    public ResultBean<Map<String,User>> findUserByName(@RequestParam(value = "name") String name)throws Exception{
        ResultBean<Map<String, User>> bean = new ResultBean<>();
        User user = userRepository.findByName(name);
        HashMap<String, User> map = new HashMap<>();
        if (user != null)
            map.put("userinfo", user);
        bean.setResult(map);
        bean.setCode("0000");
        bean.setMsg("查询成功");
        return bean;
    }
}
