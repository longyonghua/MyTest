package com.longge.mytest;

import com.longge.mytest.mapper.ProductMapper;
import com.longge.mytest.mapper.UserMapper;
import com.longge.mytest.pojo.Product;
import com.longge.mytest.service.ProductService;
import com.longge.mytest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author longyonghua
 * @create 2023-10-24-09:40
 */
@SpringBootTest
@Slf4j
public class ProductTest {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void test3(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }

    @Test
    public void test4(){
        System.out.println("a");
        System.out.println("b");
    }

    @Test
    public void test1(){
        Product product1 = productMapper.selectById(1);
        Product product2 = productMapper.selectById(1);

        product1.setPrice(product1.getPrice() + 10);
        int res1 = productMapper.updateById(product1);
        log.info("res1:{}", res1); //1

        product2.setPrice(product2.getPrice() + 20);
        int res2 = productMapper.updateById(product2);
        log.info("res2:{}", res2); //0
        if(res2 == 0){
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() + 20);
            int res = productMapper.updateById(productNew);
        }
    }

    @Test
    public void test2(){
        Product product = productMapper.selectById(1);

        product.setPrice(product.getPrice() + 10);
        int res1 = productMapper.updateById(product); //update product set name=?, price=?, version=? where id=? and version=?
        log.info("res1:{}", res1);
        log.info("商品信息：" + product); //Product(id=1, name=apple, price=110, version=1)

        product.setPrice(product.getPrice() + 20);
        int res2 = productMapper.updateById(product);
        log.info("res2:{}", res2);
        log.info("商品信息：" + product); //Product(id=1, name=apple, price=130, version=2)
    }

}
