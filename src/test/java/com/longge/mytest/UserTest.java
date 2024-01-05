package com.longge.mytest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.longge.mytest.enums.SexEnum;
import com.longge.mytest.mapper.UserMapper;
import com.longge.mytest.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Map;

/**
 * @author longyonghua
 * @create 2023-10-21-21:41
 */
@SpringBootTest
public class UserTest {
    //这里报红是因为启动类上加的@MapperScan注解，并非表示把UserMapper接口交给spring管理，而是表示把UserMapper接口动态生成的代理类对象交给spring管理
    //所以idea在编译时认为userMapper是无法进行自动装配的，但在运行阶段不会存在问题
    //若想去掉这个报红，可以在UserMapper接口上加@Mapper或@Repository注解；或者使用@Resource注解引入；或者设置idea的提示
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGenerator(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mytest?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "longge")
                .globalConfig(builder -> {
                    builder.author("longge") //设置作者
                            .enableSwagger() //开启 swagger 模式
                            .fileOverride() //覆盖已生成文件
                            .outputDir("/Users/longyonghua/Documents/ideaProject/mybatis-plus"); //指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.longge") //设置父包名
                            .moduleName("mybatisplus") //设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/longyonghua/Documents/ideaProject/mybatis-plus")); //设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") //设置需要生成的表名
                            .addTablePrefix("t_", "c_"); //设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) //使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    @Test
    public void testEnumValue(){
        User user = new User();
        user.setAge(20);
        user.setName("aa");
        user.setSex(SexEnum.MALE);
        int res = userMapper.insert(user);
    }

    @Test
    public void testSelect(){
        //通过条件构造器查询一个List集合
        /*List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);*/

        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("大佬");
        user.setAge(33);
        user.setEmail("33@qq.com");
        int res = userMapper.insert(user);
        System.out.println("res:" + res); //res:1
        System.out.println("id:" + user.getId()); //id:1715753561532469250  默认采用雪花算法生成主键id
    }

    @Test
    public void testWrapper(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = new User();
        int res = userMapper.update(null, updateWrapper);
        int res2 = userMapper.update(null, queryWrapper);
    }

    @Test
    public void testPage(){
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPage(page, null); //SELECT id,name,age,email FROM user LIMIT 3,3
        System.out.println(page.getRecords()); //当前查询出来的记录信息
        System.out.println(page.getPages()); //总页数 3
        System.out.println(page.getTotal()); //总记录数 9
        System.out.println(page.hasNext()); //是否有下一页 true
        System.out.println(page.hasPrevious()); //是否有上一页 true
    }

    @Test
    public void testPage2(){
        Page<User> page = new Page<>(2,3);
        userMapper.mySelectPage(page, 20);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

}
