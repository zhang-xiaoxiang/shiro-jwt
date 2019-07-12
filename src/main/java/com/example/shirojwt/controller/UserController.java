package com.example.shirojwt.controller;


import com.example.shirojwt.entity.User;
import com.example.shirojwt.filter.JwtFilter;
import com.example.shirojwt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 客户端用户表 前端控制器
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-07-12
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Object login(@RequestBody User user) {
        log.warn("进去了方法");
        User user1 = userService.login(user);
        if (user1 != null) {
            return user1;
        }

        return "系统错误!";
    }
}
