package com.goopal.controller;

import com.goopal.async.AsyncTask;
import com.goopal.bean.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by leon on 2016/11/3.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Resource(name = "helloWorld")
    private Hello helloWorld;

    @Autowired
    @Qualifier("helloVillage")
    private Hello helloVillage;

    @Autowired
    AsyncTask asyncTask;

    //@ApiIgnore
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    @ResponseBody
    String home() {
        return "Hello SpringBoot!";
    }

    @RequestMapping("/test")
    public String test(){
        helloVillage.dispaly();
        helloWorld.dispaly();
        return"test";
    }

    @RequestMapping("/async")
    public void async() throws  Exception{
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }
}
