package com.goopal.service.impl;

import com.goopal.domain.User;
import com.goopal.mapper.UserMapper;
import com.goopal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by leon on 2016/11/8.
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMappper;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    public List<User> likeName(String name){
        return userMappper.likeName(name);
    }


    //keyGenerator="myKeyGenerator"
    @Cacheable(value="User") //缓存,这里没有指定key.
    @Override
    public User findById(Long id) {
        System.err.println("UserServiceImpl.findById()=========从数据库中进行获取的....id="+id);
        return userMappper.getById(id);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    //@CachePut
    @CacheEvict(value="User")
    @Override
    public void deleteFromCache(Long id) {
        System.out.println("UserServiceImpl.delete().从缓存中删除.");
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public void test(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }
}
