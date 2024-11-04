package com.example.paginationdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.paginationdemo.dao.UserRepo;
import com.example.paginationdemo.entity.User;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    
    // creating User
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    
    // getting user by userId
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepo.findById(id).orElse(null);
    }

    // getting all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
    
// deleting user by userId
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
    
    
    // updating user by userId
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
    	
        User existingUser = userRepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());

        return userRepo.save(existingUser);
    }

}
