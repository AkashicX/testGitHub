package com.akashic.providerdemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName providerController
 * @Description: TODO
 * @Author:leio
 * @Date 2020/2/7
 * @Version V1.0
 **/
@RestController
public class ProviderController {
    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    public String getPort(){
      return configurableApplicationContext.getEnvironment().getProperty("server.port");
    }
    public String getName(){
        return configurableApplicationContext.getEnvironment().getProperty("spring.application.name");
    }

    @RequestMapping(value = "/echo/{message}", method = RequestMethod.GET)
  public String  echo(@PathVariable(value = "message") String msg)  {

        return ",nacos-provider被调用,"+msg+",--name--"+getName()+",--port--"+getPort();
    }
}
