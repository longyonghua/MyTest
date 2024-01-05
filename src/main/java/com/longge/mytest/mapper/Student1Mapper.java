package com.longge.mytest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.longge.mytest.pojo.Student1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author longyonghua
* @description 针对表【student1】的数据库操作Mapper
* @createDate 2023-10-25 11:36:27
* @Entity com.longge.mytest.pojo.Student1
*/
public interface Student1Mapper extends BaseMapper<Student1> {

    List<Student1> selectAllBySidOrderByAgeDesc(@Param("sid") Long sid);

}




