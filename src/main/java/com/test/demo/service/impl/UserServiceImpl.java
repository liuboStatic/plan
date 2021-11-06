package com.test.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.test.demo.entity.User;
import com.test.demo.mapper.UserMapper;
import com.test.demo.service.UserService;

/**
 * 用户service实现类
 *
 * @author liubo
 * @date 2021/11/06 09:00
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        Wrapper<User> wrapper = new QueryWrapper<User>();
        return userMapper.selectList(wrapper);
    }
}
