package com.goopal.mapper;

import com.goopal.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by leon on 2016/11/8.
 */
@Component
public interface UserMapper {
    @Select("select * from user where name like CONCAT('%',#{name}, '%')")
    public List<User> likeName(String name);

    @Select("select * from user where id = #{id}")
    public User getById(Long id);

    @Select("select name from user where id = #{id}")
    public String getNameById(Long id);

    @Insert("insert into user(name,password,age) values (#{name},#{password}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int save( User user);

    @Update("update user set name = #{name}, password = #{password}, age = #{age} where id = #{id}")
    public int update(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(Long id);
}
