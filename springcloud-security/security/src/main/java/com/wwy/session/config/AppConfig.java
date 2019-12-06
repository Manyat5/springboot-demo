package com.wwy.session.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 代替传统的application.xml配置方式
 */
@Configuration
//扫描基础包，不扫描Controller
@ComponentScan(basePackages = "com.wwy.session",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)
})
public class AppConfig {
}
