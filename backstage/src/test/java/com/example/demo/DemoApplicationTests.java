package com.example.demo;



import com.example.demo.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    UsersMapper usersMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testLogin(){
        String password = "123456";
    }

}
