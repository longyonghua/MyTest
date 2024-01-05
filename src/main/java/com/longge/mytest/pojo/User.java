package com.longge.mytest.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.longge.mytest.enums.SexEnum;
import lombok.Data;

/**
 * @author longyonghua
 * @create 2023-10-21-21:30
 */
@Data
@TableName
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private SexEnum sex;
}
