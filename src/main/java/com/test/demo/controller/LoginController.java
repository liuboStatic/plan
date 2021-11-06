package com.test.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.demo.entity.JsonResult;
import com.test.demo.entity.User;
import com.test.demo.service.UserService;

/**
 * 登录控制器
 *
 * @author liubo
 * @date 2021/11/06 14:03
 **/
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public JsonResult login(HttpServletRequest request, String account, String password) {
        if (account == null || password == null || account.isEmpty() || password.isEmpty()){
            return new JsonResult(501,"参数无效");
        }
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("account",account);
        User user = userService.getOne(wrapper);
        if (user == null){
            return new JsonResult(502,"账户不存在");
        }
        if (user.getPassword() == null || !password.equals(user.getPassword())){
            return new JsonResult(503,"密码错误");
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        return new JsonResult(200,"操作成功");
    }

    @RequestMapping("/loginOut")
    public JsonResult login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return new JsonResult(200,"操作成功");
    }
}
