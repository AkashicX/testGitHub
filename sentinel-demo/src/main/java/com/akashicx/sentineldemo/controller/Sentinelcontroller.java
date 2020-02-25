package com.akashicx.sentineldemo.controller;

import com.akashicx.sentineldemo.service.FeignForSentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Sentinelcontroller
 * @Description: TODO
 * @Author:leio
 * @Date 2020/2/8
 * @Version V1.0
 **/
@RestController
public class Sentinelcontroller {
    @Autowired
    private FeignForSentinelService feignForSentinelService;
    @RequestMapping(value = "/sentinel",method = RequestMethod.GET)
    public String sentinelTest(){
       return  feignForSentinelService.echo("调用者sentinel：");
    }
}
