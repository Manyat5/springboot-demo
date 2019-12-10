package com.wwy.client2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/r1")
    @PreAuthorize("hasAuthority('p1')")
    public String normal( ) {
        return "normal permission test success !!!";
    }

    @GetMapping("/r2")
    @PreAuthorize("hasAuthority('p2')")
    public String medium() {
        return "medium permission test success !!!";
    }

    @GetMapping("/r3")
    @PreAuthorize("hasAuthority('p3')")
    public String admin() {
        return "admin permission test success !!!";
    }
}