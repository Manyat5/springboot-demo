package com.wwy.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboardApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DashboardApp.class).properties("spring.config,name:application-dashboard").build().run(args);
    }
}
