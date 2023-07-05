package com.test.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.demo.entity.JsonResult;
import com.test.demo.entity.Plan;
import com.test.demo.entity.User;
import com.test.demo.service.PlanService;

/**
 * 计划控制层
 *
 * @author liubo
 * @date 2021/11/06 09:02
 **/
@RestController
@RequestMapping(value = "/plan")
public class PlanController {
    @Autowired
    private PlanService planService;

    private static final Logger logger = LoggerFactory.getLogger(PlanController.class);

    @RequestMapping("/save")
    public JsonResult save(HttpServletRequest request, Plan plan) {
        logger.info("计划添加参数：{}",plan);
        if (plan == null || plan.getPlanInfo() == null || plan.getPlanEndTime() == null){
            return new JsonResult(500,"参数无效");
        }
        User user = this.getSessionUser(request);
        if (user == null){
            return new JsonResult(400,"登录过期");
        }
        plan.setIsEnd(1);
        plan.setCreateTime(new Date());
        plan.setCreateUser(user.getId());
        plan.setUpdateTime(new Date());
        plan.setUpdateUser(user.getId());

        boolean result = planService.save(plan);
        logger.info("计划添加结果：{}",result);
        if (result){
            return new JsonResult(200,"操作成功");
        }else {
            return new JsonResult(500,"操作失败");
        }
    }

    @RequestMapping("/findByPage")
    public JsonResult findByPage(HttpServletRequest request, Page page) {
        User user = this.getSessionUser(request);
        if (user == null){
            return new JsonResult(400,"登录过期");
        }

        IPage iPage = planService.findByPage(user.getId(),page);
        return new JsonResult(200,"操作成功",iPage);
    }

    @RequestMapping("/updateById")
    public JsonResult updateById(HttpServletRequest request, Plan plan) {
        if (plan == null){
            return new JsonResult(500,"参数无效");
        }
        User user = this.getSessionUser(request);
        if (user == null){
            return new JsonResult(400,"登录过期");
        }
        Plan result = planService.getById(plan.getId());
        if(result == null){
            return new JsonResult(500,"修改数据无效");
        }
        if (!result.getCreateUser().equals(user.getId())){
            return new JsonResult(500,"用户操作数据不是自己的");
        }
        result.setUpdateTime(new Date());
        result.setUpdateUser(user.getId());
        result.setIsEnd(plan.getIsEnd());
        result.setPlanInfo(plan.getPlanInfo());
        result.setPlanEndTime(plan.getPlanEndTime());

        planService.updateById(result);
        return new JsonResult(200,"操作成功");
    }

    @RequestMapping("/deleteById")
    public JsonResult updateById(HttpServletRequest request, Integer id) {
        if (id == null){
            return new JsonResult(500,"参数无效");
        }
        User user = this.getSessionUser(request);
        if (user == null){
            return new JsonResult(400,"登录过期");
        }
        boolean result = planService.removeById(id);
        if(!result){
            return new JsonResult(500,"删除数据失败");
        }

        return new JsonResult(200,"操作成功");
    }

    public User getSessionUser(HttpServletRequest request){
        User user;
        if (request == null){
            return null;
        }
        HttpSession session = request.getSession();
        user = (User)session.getAttribute("user");
        return user;
    }
}
