package com.goopal.dao;

import com.goopal.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


/**
 * 使用JdbcTemplate操作数据库.
 * 
 * @author Administrator
 *
 */
@Repository
public class UserDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * 通过id获取User对象.
	 * 
	 * @param id
	 * @return
	 */
	public User getById(long id) {
		String sql = "select * from user where uid=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
