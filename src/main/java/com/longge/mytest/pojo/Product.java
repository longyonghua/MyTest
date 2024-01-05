package com.longge.mytest.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author longyonghua
 * @create 2023-10-24-09:38
 */
@Data
public class Product {

    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;

}
