package com.goopal.service;

import com.goopal.domain.User;

import java.util.List;

/**
 * Created by leon on 2016/11/8.
 */
public interface UserService {

    public List<User> likeName(String name);

    public User findById(Long id);

    public User save(User user);

    public void deleteFromCache(Long id);

    void delete(Long id);

    public int updateUser(User user);

    void test();
}
