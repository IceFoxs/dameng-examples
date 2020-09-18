package io.icefox.dmdemo.controller;

import io.icefox.dmdemo.entity.User;
import io.icefox.dmdemo.service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;


    @ResponseBody
    @RequestMapping("/getUser")
    public List<User> getUser() {
        return userService.list();
    }

    @ResponseBody
    @RequestMapping("/getUserList")
    public List<User> getUserList(@RequestBody JSONObject jsonObject) {
        Page<User> page = new Page<>();
        page.setSize(jsonObject.getInteger("pageSize"));
        page.setCurrent(jsonObject.getInteger("pageIndex"));
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery();
      //  queryWrapper.eq(User::getUsername,"赵云涛");
        IPage<User> userIPage = userService.page(page, queryWrapper);
        return userIPage.getRecords();
    }

    @ResponseBody
    @RequestMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user;
    }
}
