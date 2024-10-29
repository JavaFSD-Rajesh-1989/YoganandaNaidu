package com.case_study_practise.model;

public class User {
	
	
	private long userId; 
	
	private String username; 
	
	private String email; 
	
	private String password; 
	
	
	public User() {
		
	}
	
	private User(long userId, String username, String email, String password) {
		
		this.userId = userId; 
		this.username = username; 
		this.email = email;
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
