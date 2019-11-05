package com.wwy.ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class RibbonApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RibbonApp.class).properties("spring.config.name:application-ribbon").build().run(args);
    }
}
