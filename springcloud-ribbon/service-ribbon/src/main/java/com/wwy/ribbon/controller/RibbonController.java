package com.wwy.ribbon.controller;

import com.wwy.common.User;
import com.wwy.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;

    @GetMapping("/ribbon")
    public List<User> hi() {
        return ribbonService.hiService();
    }
}
