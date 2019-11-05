package com.wwy.ribbon.service;

import com.wwy.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    public List<User> hiService() {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/users", List.class);
    }
}
