package com.akashicx.sentineldemo.service;

import com.akashicx.sentineldemo.service.fallback.NacosProviderFallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName FeignForSentinelService
 * @Description: TODO
 * @Author:leio
 * @Date 2020/2/8
 * @Version V1.0
 **/
@FeignClient(value = "nacos-provider",fallback = NacosProviderFallBack.class)
public interface FeignForSentinelService {

    @RequestMapping(value = "/echo/{message}",method = RequestMethod.GET)
    String echo(@PathVariable("message") String message);
}
