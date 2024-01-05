package com.longge.mytest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longge.mytest.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author longyonghua
 * @create 2023-10-21-21:35
 */
public interface UserMapper extends BaseMapper<User> {

    Map<String, Object> selectMapById(Long id);

    /*
        参数Page 是mp提供的分页对象，必须放在第一个参数的位置
        返回值必须是Page对象
     */
    Page<User> mySelectPage(@Param("page") Page<User> page, @Param("age") Integer age);

    int insertSelective(User user);

}
