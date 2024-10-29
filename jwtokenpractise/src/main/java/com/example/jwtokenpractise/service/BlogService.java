package com.example.jwtokenpractise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwtokenpractise.entity.Blog;
import com.example.jwtokenpractise.entity.User;
import com.example.jwtokenpractise.repo.BlogRepo;

@Service
public class BlogService {
	
    @Autowired
    private BlogRepo blogRepository;

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog updateBlog(Long id, Blog blog) {
        blog.setId(id);
        return blogRepository.save(blog);
    }

    public boolean deleteBlog(Long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
