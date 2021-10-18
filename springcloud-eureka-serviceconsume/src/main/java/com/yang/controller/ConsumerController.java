package com.yang.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class ConsumerController {
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer")
    public String helloworld(String str){
        System.out.println("传入的值为：" + str);

        //第一种调用方式
//        String forObject = new RestTemplate().getForObject("http://localhost:8701/hello/world?str=" + str, String.class);

        //第二种调用方式
        //根据服务名 获取服务列表 根据算法选取某个服务 并访问某个服务的网络位置。
//        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-service");
//        String forObject = new RestTemplate().getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello/world?str=" + str, String.class);

        //第三种调用方式 需要restTemplate注入的方式
        String forObject = restTemplate.getForObject("http://EUREKA-SERVICE/hello/world?str=" + str, String.class);
        return forObject;
    }

}
