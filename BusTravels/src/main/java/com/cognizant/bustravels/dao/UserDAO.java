package com.cognizant.bustravels.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.bustravels.bean.User;
import com.cognizant.bustravels.exception.UserException;

@Repository
public class UserDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean verifyLogin(User user)throws UserException
	{
		String sql="select * from users where email_id=? and password=?";
		try
		{
			List<User> user1=jdbcTemplate.query(sql,new UserRowMapper(),user.getEmail_id(),user.getPassword());
			if(user1.isEmpty())
			  throw new UserException("Invalid User Credentails");
			else
				return true;
		}
		catch(DataAccessException e)
		{
			throw new UserException("Required to fill Email_id or password");
		}
	}
	
	public boolean addUser(User user) throws UserException
	{
		try
		{
		String sql="insert into users values(?,?,?,?,?)";
		return jdbcTemplate.update(sql,user.getUsername(),user.getEmail_id(),user.getPhone(),user.getGender(),user.getPassword())>0;
		}
		catch(DuplicateKeyException e)
		{
			throw new UserException("User is already registered");
		}
		
	}

}
