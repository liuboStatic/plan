package com.test.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.test.demo.entity.Plan;

/**
 * 计划mapper接口
 *
 * @author liubo
 * @date 2021/11/06 08:57
 **/
@Repository
public interface PlanMapper extends BaseMapper<Plan> {

    @Select("SELECT * FROM `tb_plan` where create_user = #{id} order by plan_end_time DESC")
    IPage<Plan> findByPage(IPage iPage,@Param("id") Integer id);
}
