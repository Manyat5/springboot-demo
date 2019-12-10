package com.wwy.client1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wwy
 */
@RestController
public class Client1Controller {
    @GetMapping("/r1")
    @PreAuthorize("hasAuthority('p1')")
    public String r1(){
        return "r1资源";
    }
    @GetMapping("/r3")
    @PreAuthorize("hasAuthority('p3')")
    public String r3(){
        return "r3资源";
    }
}
