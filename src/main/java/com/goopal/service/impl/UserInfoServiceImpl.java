package com.goopal.service.impl;

import com.goopal.dao.jpa.UserInfoRepository;
import com.goopal.domain.UserInfo;
import com.goopal.service.UserInfoService;

import javax.annotation.Resource;

/**
 * Created by leon on 2016/11/13.
 */
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }
}
