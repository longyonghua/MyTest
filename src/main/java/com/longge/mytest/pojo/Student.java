package com.longge.mytest.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author longyonghua
 * @create 2023-10-22-12:42
 */
@Data
public class Student {

    @TableId(type = IdType.ASSIGN_ID)
    private Long sid;
    private String name;
    private Integer age;
    private String email;

}
