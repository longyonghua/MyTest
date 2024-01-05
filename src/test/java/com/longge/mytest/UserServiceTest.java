package com.longge.mytest;

import com.longge.mytest.pojo.User;
import com.longge.mytest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author longyonghua
 * @create 2023-10-22-11:15
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGet(){
        //查询总记录数
        long count = userService.count();
        System.out.println("总记录数：" + count); //select count(*) from user

        //查询所有
        List<User> users = userService.list(); //SELECT id,name,age,email FROM user
        System.out.println(users);

        //根据多个id查询list集合
        List<User> users2 = userService.listByIds(Arrays.asList(1L, 2L)); //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? )
        System.out.println(users2);



    }

    @Test
    public void testSave(){
        //批量新增
        List<User> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            User user = new User();
            user.setName("long" + i);
            user.setAge(20 + i);
            list.add(user);
        }
        boolean res = userService.saveBatch(list); //执行多次该命令：INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
    }


}
