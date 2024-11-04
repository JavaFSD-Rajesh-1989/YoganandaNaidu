package com.example.paginationdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paginationdemo.entity.Blogs;

@Repository
public interface BlogRepo extends JpaRepository<Blogs, Long>{

	   List<Blogs> findByUserUserId(Long userId);
}
