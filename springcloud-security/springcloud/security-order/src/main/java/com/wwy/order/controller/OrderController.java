package com.wwy.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wwy
 */
@RestController
public class OrderController {

    @GetMapping("/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String order(){
        return "订单资源服务";
    }
    @GetMapping("/r2")
    @PreAuthorize("hasAnyAuthority('p2')")
    public String p2(){
        return "订单资源服务,需要拥有p2权限才可以访问";
    }
}
