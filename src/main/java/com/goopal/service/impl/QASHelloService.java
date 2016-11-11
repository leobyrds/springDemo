package com.goopal.service.impl;

import com.goopal.service.HelloService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by leon on 2016/11/10.
 */
@Service
@Profile("qas") //生产环境.
public class QASHelloService implements HelloService{
    @Override
    public String getName() {
        return "hello QAS";
    }
}
