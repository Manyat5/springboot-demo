package com.wwy.consumer;

import com.wwy.common.User;
import com.wwy.consumer.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.wwy.consumer.ConsumerApp.class)
public class Test1 {
    @Autowired
    private DemoService demoService;

    @Test
    public void test1(){
        List<User> users = demoService.getUsers();
        System.out.println(users);
    }
}
