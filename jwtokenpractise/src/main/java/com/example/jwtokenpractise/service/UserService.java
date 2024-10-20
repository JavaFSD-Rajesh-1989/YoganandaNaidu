package com.example.jwtokenpractise.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwtokenpractise.entity.User;
import com.example.jwtokenpractise.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
    
	public Optional<User> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public Optional<User> findById(Long id) {
	    return userRepo.findById(id);
	}

	
	public boolean deleteUser(Long id) {
	    Optional<User> userOptional = userRepo.findById(id);
	    if (userOptional.isPresent()) {
	        userRepo.delete(userOptional.get()); 
	        return true; 
	    }
	    return false; 
	}
}

