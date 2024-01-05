package com.longge.mytest.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longge.mytest.mapper.ProductMapper;
import com.longge.mytest.pojo.Product;
import org.springframework.stereotype.Service;

/**
 * @author longyonghua
 * @create 2023-10-24-16:59
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService{
}
