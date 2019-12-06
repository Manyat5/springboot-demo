package com.wwy.uaa.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wwy
 */
@RestController
public class LoginController {

    @GetMapping(value = "/login-success",produces = {"text/plain;charset=utf-8"})
    @PreAuthorize("hasAnyAuthority('p1','p2')")
    public String login(){
        return "login success!";
    }
}
