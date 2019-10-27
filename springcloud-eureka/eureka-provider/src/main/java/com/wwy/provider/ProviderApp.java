package com.wwy.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderApp.class).properties("spring.config.name:application-provider").build().run(args);
    }
}

