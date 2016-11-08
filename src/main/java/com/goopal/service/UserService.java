package com.goopal.service;

import com.goopal.domain.User;

import java.util.List;

/**
 * Created by leon on 2016/11/8.
 */
public interface UserService {

    public List<User> likeName(String name);

    public User findById(long id);

    public void deleteFromCache(long id);

    void test();
}
