package com.wwy.feign.service;

import com.wwy.common.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("eureka-provider")
public interface FeignService {
    @GetMapping("/users")
    public List<User> getUsersFromClient() ;
}
