package com.wwy.provider.controller;

import com.wwy.common.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
    @GetMapping("/users")
    public List<User> listAll(){
        List<User> users=new ArrayList<>();
        users.add(new User(1,"zs"));
        users.add(new User(2,"李四"));
        return users;
    }
}
