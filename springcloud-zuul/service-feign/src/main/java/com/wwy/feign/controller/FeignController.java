package com.wwy.feign.controller;

import com.wwy.common.User;
import com.wwy.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @GetMapping("/feign")
    public List<User> hi() {
        return feignService.getUsersFromClient();
    }
}