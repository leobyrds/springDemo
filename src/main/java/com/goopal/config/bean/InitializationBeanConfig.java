package com.goopal.config.bean;

import org.goopal.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 飞鸟 (feiniao@51huxin.com)
 * @createDate: 2017/1/16
 * @company: (C) Copyright 阳光互信 2017
 * @since: JDK 1.8
 * @description:
 */
@Configuration
public class InitializationBeanConfig {
    @Bean(initMethod="init",destroyMethod="destroy")
    public HelloService helloService(){
        System.out.println("-------------in InitializationBeanConfig bean------------------");
        return new HelloService();
    }
}
