package com.goopal.controller;

import com.github.pagehelper.PageHelper;
import com.goopal.domain.User;
import com.goopal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.goopal.controller.SwaggerController.users;

/**
 * Created by leon on 2016/11/8.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier(value = "UserServiceImpl")
    private UserService userService;

    @RequestMapping("/likeName")
    public List<User> likeName(String name) {
        PageHelper.startPage(1, 1);
        return userService.likeName(name);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        User loaded = userService.findById(1l);
        System.out.println("loaded=" + loaded);
        User cached = userService.findById(1l);
        System.out.println("cached=" + cached);
        loaded = userService.findById(2l);
        System.out.println("loaded2=" + loaded);
        return "ok";
    }

    @RequestMapping(value="", method= RequestMethod.POST, consumes = {"application/json"})
    public String postUser(@RequestBody @Valid User user, BindingResult result, Model model) {
        users.put(user.getId(), user);
        if(result.hasErrors()){
            List<ObjectError>  list = result.getAllErrors();
            for(ObjectError  error:list){
                System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
            }

            return "demo";
        }
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        userService.deleteFromCache(id);
        return "ok";
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        userService.test();
        System.out.println("UserController.test1()");
        return "ok";
    }
}
