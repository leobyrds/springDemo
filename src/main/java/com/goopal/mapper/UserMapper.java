package com.goopal.mapper;

import com.goopal.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by leon on 2016/11/8.
 */
public interface UserMapper {
    @Select("select * from user where name like CONCAT('%',#{name}, '%')")
    public List<User> likeName(String name);

    @Select("select * from user where id = #{id}")
    public User getById(long id);

    @Select("select name from user where id = #{id}")
    public String getNameById(long id);
}
