package com.wwy.provider2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Provider2App {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Provider2App.class).properties("spring.config.name:application-provider2").build().run(args);
    }
}

