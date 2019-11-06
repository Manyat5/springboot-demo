package com.wwy.feign.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public IRule myRule(){
        return new RandomRule();//随机算法
    }

//    @Bean
//    public Sampler defaultSampler() {
//        return Sampler.ALWAYS_SAMPLE;
//    }
}
