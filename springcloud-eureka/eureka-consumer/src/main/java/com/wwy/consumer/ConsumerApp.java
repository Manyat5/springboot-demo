package com.wwy.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsumerApp.class).
                properties("spring.config.name:application-consumer").build().run(args);
    }
}
