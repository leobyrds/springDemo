package com.goopal.mapper;

import com.goopal.domain.UserInfo;

/**
 * Created by leon on 2016/11/13.
 */
//@Component
public interface UserInfoMapper {
    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);
}
