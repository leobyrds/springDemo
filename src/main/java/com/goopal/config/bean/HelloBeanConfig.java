package com.goopal.config.bean;

import com.goopal.bean.Hello;
import com.goopal.service.HelloService;
import com.goopal.service.impl.DevHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by leon on 2016/11/9.
 */
@Configuration
public class HelloBeanConfig {
    /**
     *  这里只是测试使用，没有实际的意义.
     */
    @Autowired
    private HelloService helloService;

    @Bean(name="testHelloService")
    public HelloService filterRegistrationBean(@Qualifier("helloWorld") Hello hello){
//        HelloService helloService = new DevHelloService();
        helloService.getName();
        hello.dispaly();
        // 其它处理代码.
        return helloService;
    }
}
