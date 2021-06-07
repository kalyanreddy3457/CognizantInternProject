package com.cognizant.bustravels.service;

import java.util.List;

import com.cognizant.bustravels.bean.User;
import com.cognizant.bustravels.exception.UserException;

public interface IUserService {

	public boolean verifyLogin(User user)throws UserException;
	public boolean addUser(User user)throws UserException;
	public boolean updateProfile(User user, String email_id)throws UserException;
	public boolean changePassword(User user, String email_id) throws UserException;
	public List<User> viewProfile(String email_id) throws UserException;
}
