package com.akashic.consumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "nacos-provider")
public interface ConsumerFeignProviderService {


    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable("message") String message);
}
