package com.test.demo.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.demo.entity.User;

/**
 * 用户mapper接口
 *
 * @author liubo
 * @date 2021/11/06 08:57
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {

}
