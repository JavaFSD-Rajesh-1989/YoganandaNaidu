package com.case_study_practise.service;

import com.case_study_practise.dao.UserDaoInterface;
import com.case_study_practise.model.User;
import com.case_study_practise.util.DaoFactory;


public class UserService implements UserServiceInterface {
	
	

	@Override
	public User RegisterUser(User user) {
		UserDaoInterface userDao = DaoFactory.UserObject("user"); 
		return userDao.RegisterUser(user);
	}

	@Override
	public User LoginUser(User user) {
		UserDaoInterface userDao = DaoFactory.UserObject("user"); 
		return userDao.LoginUser(user);
	}

}
