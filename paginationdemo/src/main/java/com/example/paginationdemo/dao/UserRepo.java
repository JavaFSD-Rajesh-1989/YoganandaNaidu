package com.example.paginationdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paginationdemo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
