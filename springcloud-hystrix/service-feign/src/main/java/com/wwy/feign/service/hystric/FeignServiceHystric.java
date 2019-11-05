package com.wwy.feign.service.hystric;

import com.wwy.common.User;
import com.wwy.feign.service.FeignService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class FeignServiceHystric implements FeignService {
    @Override
    public List<User> getUsersFromClient() {
        ArrayList<User> users = new ArrayList<>(1);
        users.add(new User(Integer.MAX_VALUE,"错误信息"));
        return users;
    }
}
