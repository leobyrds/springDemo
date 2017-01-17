package com.goopal.dao.jpa;

import com.goopal.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by leon on 2016/11/13.
 */
public interface  UserInfoRepository extends CrudRepository<UserInfo,Long> {

    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);
}
