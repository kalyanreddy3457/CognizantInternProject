package com.cognizant.bustravels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.bustravels.bean.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString(1));
		user.setEmail_id(rs.getString(2));
		user.setPhone(rs.getString(3));
		user.setGender(rs.getString(4));
		user.setPassword(rs.getString(5));
		
		return user;
	}
	

}