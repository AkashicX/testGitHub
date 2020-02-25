package com.akashicx.consumerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerConfigration
 * @Description: TODO
 * @Author:leio
 * @Date 2020/2/8
 * @Version V1.0
 **/
@Configuration//相当于spring-context。xml
public class ConsumerConfigration {
    @Bean//相当于<bean>
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
