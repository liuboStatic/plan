package com.test.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test.demo.entity.Plan;

public interface PlanService extends IService<Plan> {

    IPage<Plan> findByPage(Integer id, IPage page);
}
