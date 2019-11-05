package com.wwy.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wwy.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public List<User> hiService() {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/users", List.class);
    }

    public List<User> hiError(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(999,"错误信息"));
        return users;
    }
}
