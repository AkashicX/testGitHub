package com.akashicx.consumerdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @ClassName consumerController
 * @Description: TODO
 * @Author:leio
 * @Date 2020/2/7
 * @Version V1.0
 **/
@RestController
public class ConsumerController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping(value = "/rpcProvider", method = RequestMethod.GET)
    public String rpcProvider() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
        Map<String, String> map = serviceInstance.getMetadata();
        for (String key : map.keySet()) {
            System.out.println("key:" + key + "--value:" + map.get(key));
        }
        System.out.println(url);
        return "nacos-consume调用," + restTemplate.getForObject(url, String.class);
    }
}
