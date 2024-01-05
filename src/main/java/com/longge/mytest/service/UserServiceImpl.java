package com.longge.mytest.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longge.mytest.mapper.UserMapper;
import com.longge.mytest.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author longyonghua
 * @create 2023-10-22-11:12
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
