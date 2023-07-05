package com.test.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.entity.User;
import com.test.demo.service.UserService;

/**
 * 用户控制层
 *
 * @author liubo
 * @date 2021/11/06 09:02
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping("/getAll")
    public List getAll() {
        List<User> list = userService.list();
        logger.info("用户集合结果：{}",list);
        return list;
    }

    @RequestMapping("/save")
    public boolean save(User user) {
        logger.info("用户添加参数：{}",user);
        if (user == null || user.getName().isEmpty()){
            return false;
        }
        boolean result = userService.save(user);
        logger.info("用户添加结果：{}",result);
        return result;
    }
}
