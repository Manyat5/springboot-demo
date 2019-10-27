package com.wwy.consumer.controller;

import com.wwy.common.User;
import com.wwy.consumer.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/consumer")
    public List<User> consumer(){
        return demoService.getUsers();
    }
}
