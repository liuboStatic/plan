package com.test.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.demo.entity.Plan;
import com.test.demo.mapper.PlanMapper;
import com.test.demo.service.PlanService;

/**
 * 计划service实现类
 *
 * @author liubo
 * @date 2021/11/06 09:00
 **/
@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan> implements PlanService {
    @Autowired
    private PlanMapper planMapper;

    @Override
    public IPage<Plan> findByPage(Integer id, IPage iPage) {
        return planMapper.findByPage(iPage,id);
    }
}
