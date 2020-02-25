package com.akashicx.sentineldemo.service.fallback;

import com.akashicx.sentineldemo.service.FeignForSentinelService;
import org.springframework.stereotype.Component;

/**
 * @ClassName NacosProviderFallBack
 * @Description: TODO
 * @Author:leio
 * @Date 2020/2/8
 * @Version V1.0
 **/
@Component
public class NacosProviderFallBack implements FeignForSentinelService {

    @Override
    public String echo(String message) {
        return "熔断返回结果：";
    }
}
