package com.wwy.session.service;


import com.wwy.session.model.AuthenticationRequest;
import com.wwy.session.model.UserDto;

public interface AuthenticationService {
    /**
     * 用户认证
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
