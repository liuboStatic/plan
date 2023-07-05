package com.test.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.demo.entity.User;

public interface UserService extends IService<User> {

    List<User> list();
}
