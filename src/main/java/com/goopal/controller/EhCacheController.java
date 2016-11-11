package com.goopal.controller;

import com.goopal.domain.User;
import com.goopal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leon on 2016/11/8.
 */
@RestController
@RequestMapping("/ehcache")
public class EhCacheController {
    @Autowired
    @Qualifier(value = "UserServiceEhCacheImpl")
    private UserService userService;

    @RequestMapping("/test")
    public String test(){

        //存入两条数据.
        User user = new User();
        user.setName("张三");
        user.setPassword("123456");
        User user2 = userService.save(user);

        //不走缓存.
        System.out.println(userService.findById(user2.getId()));
        //走缓存.
        System.out.println(userService.findById(user2.getId()));


        user = new User();
        user.setName("李四");
        user.setPassword("123456");
        User user3 = userService.save(user);

        //不走缓存.
        System.out.println(userService.findById(user3.getId()));
        //走缓存.
        System.out.println(userService.findById(user3.getId()));

        System.out.println("============修改数据=====================");
        //修改数据.
        User updated = new User();
        updated.setName("李四-updated");
        updated.setPassword("123456");
        updated.setId(user3.getId());

        System.out.println(userService.updateUser(updated));


        //不走缓存.
        System.out.println(userService.findById(user2.getId()));

        return "ok";
    }

}
