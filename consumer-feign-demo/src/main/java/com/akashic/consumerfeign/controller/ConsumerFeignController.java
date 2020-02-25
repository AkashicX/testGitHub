package com.akashic.consumerfeign.controller;


import com.akashic.consumerfeign.service.ConsumerFeignProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConsumerFeignController
 * @Description: TODO
 * @Author:leio
 * @Date 2020/2/8
 * @Version V1.0
 **/
@RestController
public class ConsumerFeignController {
    @Autowired
    private ConsumerFeignProviderService consumerFeignProviderService;
    @RequestMapping(value = "/feign",method = RequestMethod.GET)
    public String cousumerFeign(){
        return consumerFeignProviderService.echo("nacos-consume-feign调用,");
    }
}
