package com.goopal;

import com.goopal.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by leon on 2016/11/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
    @Resource
    private HelloService helloService;

    @Test
    public void testGetName(){
        Assert.assertEquals("hello",helloService.getName());
    }
}
