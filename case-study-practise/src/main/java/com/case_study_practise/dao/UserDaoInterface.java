package com.case_study_practise.dao;

import com.case_study_practise.model.User;

public interface UserDaoInterface {

	User RegisterUser(User user);

	User LoginUser(User user);

}
