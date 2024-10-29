package com.case_study_practise.util;

import com.case_study_practise.dao.*;

public class DaoFactory {

	
	public static UserDaoInterface UserObject(String daoType) {
        if (daoType.equals("user")) {
            return new UserDao(); 
        }
        return null; 
    }
	
	
	public static BlogDaoInterface BlogObject(String daoType) {
		if(daoType.equals("blog")) {
			return new BlogDao();
		}
		return null; 
	}
}
