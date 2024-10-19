package com.example.jwtokenpractise.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwtokenpractise.entity.Blog;
import com.example.jwtokenpractise.entity.User;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {

	List<Blog> findAllByAuthor(User user);

	List<Blog> findByTitleContaining(String query);

}
