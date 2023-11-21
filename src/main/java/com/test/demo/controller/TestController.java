package com.test.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController{

    @Autowired
    HttpServletResponse httpServletResponse;

    @RequestMapping(value = "/v1/test")
    public void test(){
        httpServletResponse.setHeader("Content-Type","text/html;charset=UTF-8");
//        httpServletResponse.setHeader("Content-Type","text/plain;charset=UTF-8");
        try {
            PrintWriter writer = httpServletResponse.getWriter();
            writer.println("<h1>123</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
