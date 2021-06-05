package com.cognizant.bustravels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bustravels.bean.User;
import com.cognizant.bustravels.dao.UserDAO;
import com.cognizant.bustravels.exception.UserException;

@Service
public class UserService implements IUserService{
	
	@Autowired
	UserDAO userDAO;
	
	public boolean verifyLogin(User user)throws UserException
	{
		return userDAO.verifyLogin(user);
	}
	public boolean addUser(User user)throws UserException
	{
		return userDAO.addUser(user);
	}
}
