package com.wwy.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigApp.class).properties("spring.config.name:application-config").build().run(args);
    }
}
