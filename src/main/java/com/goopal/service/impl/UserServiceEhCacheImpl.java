package com.goopal.service.impl;

import com.goopal.domain.User;
import com.goopal.mapper.UserMapper;
import com.goopal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by leon on 2016/11/8.
 */
@Service("UserServiceEhCacheImpl")
public class UserServiceEhCacheImpl implements UserService {
    @Autowired
    private UserMapper userMappper;

    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'user'";

    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String USER_CACHE_NAME = "userCache";

    /**
     * 删除数据.
     * @param id
     */
    @CacheEvict(value = USER_CACHE_NAME,key = "'userInfo_'+#id")//这是清除缓存.
    @Override
    public void delete(Long id) {
        userMappper.delete(id);
    }

    /**
     * http://www.mincoder.com/article/2096.shtml:
     *
     * 修改数据.
     *
     * 在支持Spring Cache的环境下，对于使用@Cacheable标注的方法，Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，
     * 如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
     *
     * @CachePut也可以声明一个方法支持缓存功能。
     * 与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
     * 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
     *
     * @CachePut也可以标注在类上和方法上。使用@CachePut时我们可以指定的属性跟@Cacheable是一样的。
     *
     * @param user
     * @return
     *
     */
    @CachePut(value = USER_CACHE_NAME,key = "'userInfo_'+#user.getId()")
    @Override
    public int updateUser(User user) {
        User u = userMappper.getById(user.getId());
        if (u==null) throw new IllegalArgumentException("");
        u.setName(user.getName());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());

        return userMappper.update(u);
    }

    /**
     * 查询数据.
     * @param id
     * @return
     */
    @Cacheable(value=USER_CACHE_NAME,key="'userInfo_'+#id")
    @Override
    public User findById(Long id) {
        System.out.println("没有走缓存！"+id);
        return userMappper.getById(id);
    }

    @CacheEvict(value=USER_CACHE_NAME,key=CACHE_KEY)
    @Override
    public User save(User user) {
        userMappper.save(user);
        return user;
    }

    /**
     * 删除数据.
     * @param id
     */
    @CacheEvict(value = USER_CACHE_NAME,key = "'userInfo_'+#id")//这是清除缓存.
    @Override
    public void deleteFromCache(Long id) {

    }

    @Override
    public List<User> likeName(String name) {
        return null;
    }

    @Override
    public void test() {

    }
}
