package com.longge.mytest;

import com.longge.mytest.mapper.StudentMapper;
import com.longge.mytest.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author longyonghua
 * @create 2023-10-22-12:42
 */
@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testInsert(){
        Student student = new Student();
        student.setAge(18);
        student.setName("大佬");
        student.setEmail("22@qq.com");
        int res = studentMapper.insert(student);
    }

}
