package com.example.jwtokenpractise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwtokenpractise.entity.Blog;
import com.example.jwtokenpractise.entity.User;
import com.example.jwtokenpractise.repo.BlogRepo;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepo blogRepo;
	
	public Blog createBlog(Blog blog) {
		return blogRepo.save(blog);
	}
	
	public List<Blog> getAllBlogs() {
		return blogRepo.findAll();
	}
	
	public List<Blog> getAllBlogsByUser(User user){
		return blogRepo.findAllByAuthor(user);
	}
	
	public List<Blog> searchBlogs(String query) {
		return blogRepo.findByTitleContaining(query);
	}
	
	public Blog updateBlog(Long id, Blog blogDetails) {
	    Blog blog = blogRepo.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
	    blog.setTitle(blogDetails.getTitle());
	    blog.setDescription(blogDetails.getDescription());
	    return blogRepo.save(blog);
	}

	public void deleteBlog(Long id) {
	    blogRepo.deleteById(id);
	}

	
	

}
