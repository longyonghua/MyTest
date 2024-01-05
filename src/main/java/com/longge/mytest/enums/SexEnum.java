package com.longge.mytest.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author longyonghua
 * @create 2023-10-24-11:36
 */
@Getter
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    @EnumValue
    private Integer sex;
    private String desc;

    SexEnum(Integer sex, String desc) {
        this.sex = sex;
        this.desc = desc;
    }
}
