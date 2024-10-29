package com.case_study_practise.util;

import com.case_study_practise.service.UserService;
import com.case_study_practise.service.UserServiceInterface;

public class ServiceFactory {

	public static UserServiceInterface UserObject(String serviceType) {
        if (serviceType.equals("user")) {
            return new UserService(); 
        }
        return null; 
    }
}
