package com.case_study_practise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.case_study_practise.model.User;
import com.case_study_practise.util.DatabaseConnection;


public class UserDao implements UserDaoInterface {

    @Override
    public User RegisterUser(User user) {
       User  result = null;

        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());

          int  i = pstmt.executeUpdate();
          
          
			if(i>0) {
				result = new User(); 
				result.setUserId(user.getUserId());
				result.setUsername(user.getUsername());
				result.setEmail(user.getEmail());
				result.setPassword(user.getPassword());

			}
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;  
    }

	@Override
	public User LoginUser(User user) {
		
		User userLogged = null; 
		
		try {
			
			Connection con = DatabaseConnection.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from user where email=? and password=?");
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				userLogged = new User();
				
				userLogged.setUserId(rs.getLong("userId"));
				userLogged.setUsername(rs.getString("username"));
				userLogged.setEmail(rs.getString("email"));
				userLogged.setPassword(rs.getString("password"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return userLogged;
	}

}
