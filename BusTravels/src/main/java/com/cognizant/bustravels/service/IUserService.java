package com.cognizant.bustravels.service;

import com.cognizant.bustravels.bean.User;
import com.cognizant.bustravels.exception.UserException;

public interface IUserService {

	public boolean verifyLogin(User user)throws UserException;
	public boolean addUser(User user)throws UserException;
}
