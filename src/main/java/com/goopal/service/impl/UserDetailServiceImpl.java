package com.goopal.service.impl;

import com.goopal.service.UserDetailService;

/**
 * @author: 飞鸟 (feiniao@51huxin.com)
 * @createDate: 2016/12/17
 * @company: (C) Copyright 阳光互信 2016
 * @since: JDK 1.8
 * @description:
 */
public class UserDetailServiceImpl implements UserDetailService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = null;
//        // user = repository.findByUsername(username);
//        if(user != null){
//            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//
//            return new org.springframework.security.core.userdetails
//                    .User(user.getName(),user.getPassword(),authorities);
//        }
//
//        throw new UsernameNotFoundException("User '" + username + "' not found.");
//    }
}
