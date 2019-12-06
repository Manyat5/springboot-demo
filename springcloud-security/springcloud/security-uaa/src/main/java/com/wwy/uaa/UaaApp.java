package com.wwy.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wwy
 */
@SpringBootApplication
//@EnableFeignClients
//@EnableHystrix
public class UaaApp {
    public static void main(String[] args) {
        SpringApplication.run(UaaApp.class,args);
    }
}
