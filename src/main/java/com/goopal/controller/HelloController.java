package com.goopal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by leon on 2016/11/3.
 */
@Controller
public class HelloController {
    //@ApiIgnore
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    @ResponseBody
    String home() {
        return "Hello SpringBoot!";
    }
}
