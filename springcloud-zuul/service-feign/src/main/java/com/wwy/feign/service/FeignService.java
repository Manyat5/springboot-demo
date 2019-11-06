package com.wwy.feign.service;

import com.wwy.common.User;
import com.wwy.feign.service.factory.FeignServiceFallbackFactory;
import com.wwy.feign.service.hystric.FeignServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "eureka-provider",fallback = FeignServiceHystric.class,fallbackFactory = FeignServiceFallbackFactory.class)
public interface FeignService {
    @GetMapping("/users")
    List<User> getUsersFromClient() ;
}
