package com.wwy.uaa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wwy
 */
@Controller
public class PageController {
    private final static Logger log= LoggerFactory.getLogger(PageController.class);
//    @RequestMapping("/{page}")
//    public String showPage(@PathVariable("page") String page){
//        return page;
//    }

    @RequestMapping("/r/{page}")
    public String RPage(@PathVariable("page") String page) {
        log.info("当前登录的用户名为：{}",getUsername());
        return "r/"+page;
    }
    private String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
