package com.example.shirojwt.serviceimpl;

import com.example.shirojwt.entity.User;
import com.example.shirojwt.dao.UserDao;
import com.example.shirojwt.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 客户端用户表 服务实现类
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-07-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_phone", user.getUserPhone());
        map.put("user_password",user.getUserPassword());
        return userDao.selectByMap(map).get(0);
    }

    /**
     * 通过用户(电话号码)查询用户
     * 原则不允许重复注册,只有测试阶段才会出现,上线时不允许的
     *
     * @param userPhone
     * @return
     */
    @Override
    public User findByUserName(String userPhone) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_phone", userPhone);
        return userDao.selectByMap(map).get(0);
    }
}
