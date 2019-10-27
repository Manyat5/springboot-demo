package com.wwy.consumer.service;

import com.wwy.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DemoService {
    @Autowired
    private LoadBalancerClient loadBalancerClient;//ribbon负载均衡器

    public List<User> getUsers(){
        //选择调用的服务名称，获取一个ServiceInstance对象，这个对象封装了服务的基本信息，如ip,端口
        ServiceInstance si = loadBalancerClient.choose("eureka-provider");
        //拼接访问服务的URL
        String serviceUrl=si.getUri()+"/users";
        System.out.println("服务url="+serviceUrl);
        //使用SpringMVC restTemplate调用服务
        RestTemplate restTemplate=new RestTemplate();
        //处理MVC调用的返回值,这是一个没有抽象方法的抽象类
        ParameterizedTypeReference<List<User>> type=new ParameterizedTypeReference<List<User>>() { };
        /*ResponseEntity封装了返回值信息
        * 参数1：请求的url地址，参数2:使用什么请求方式，参数3：请求参数，4：请求返回类型ParameterizedTypeReference
        * */
        ResponseEntity<List<User>> responseEntity=restTemplate.exchange(serviceUrl, HttpMethod.GET,null,type);
        return responseEntity.getBody();
    }
}

