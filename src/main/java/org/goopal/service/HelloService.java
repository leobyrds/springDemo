package org.goopal.service;

import org.springframework.stereotype.Service;

/**
 * @author: 飞鸟 (feiniao@51huxin.com)
 * @createDate: 2017/1/16
 * @company: (C) Copyright 阳光互信 2017
 * @since: JDK 1.8
 * @description:
 */
@Service
public class HelloService {
    public void init(){
        System.out.println("init-method-bean");
    }

    /**
     * 启动的时候观察控制台是否打印此信息;
     */
    public HelloService(){
        System.out.println("load external resource start!");
        System.out.println("org.goopal.service.HelloService.HelloService()");
        System.out.println("load external resource finish!");
    }

    public void destroy(){
        System.out.println("destory-method-bean");
    }
}
