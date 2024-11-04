package com.example.paginationdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.paginationdemo.dao.BlogRepo;
import com.example.paginationdemo.dao.UserRepo;
import com.example.paginationdemo.entity.Blogs;
import com.example.paginationdemo.entity.User;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
	private BlogRepo blogRepo; 
	
	@Autowired
	private UserRepo userRepo; 
	
	
	// creating blogs using userId for the particular user 
	@PostMapping("/{userId}/createBlog")
	public Blogs createBlog(@PathVariable Long userId ,@RequestBody Blogs blog) {
		User user = userRepo.findById(userId).get(); 
		blog.setUser(user);
		return blogRepo.save(blog);
	}
	
	// getting all blogs by using pagination. Retrieveing 4 blogs per page. Default page number is 0 
	@GetMapping("/allBlogs")
	public Page<Blogs> getAllBlogs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
		Pageable pageable = PageRequest.of(page, size); 
		return blogRepo.findAll(pageable);
	}
	
	// getting blog by blog Id
	@GetMapping("/{blogId}")
	public Blogs getBlogById(@PathVariable Long blogId) {
		return blogRepo.findById(blogId).get();
	}
	
	// getting all blogs by the userId 
    @GetMapping("/user/{userId}")
    public List<Blogs> getBlogsByUserId(@PathVariable Long userId) {
        return blogRepo.findByUserUserId(userId);
    }
    
    
    //Updating a blog by blogId
    @PutMapping("/updateBlog/{blogId}")
    public Blogs updateBlog(@PathVariable Long blogId, @RequestBody Blogs updatedBlog) {
        Blogs existingBlog = blogRepo.findById(blogId)
            .orElseThrow(() -> new RuntimeException("Blog not found with id: " + blogId));
        

        existingBlog.setBlogName(updatedBlog.getBlogName());
        existingBlog.setBlogContent(updatedBlog.getBlogContent());
        existingBlog.setCreatedAt(updatedBlog.getCreatedAt());
    
        return blogRepo.save(existingBlog);
    }

    // deleting blog by blogId
    @DeleteMapping("/{blogId}")
    public void deleteBlog(@PathVariable Long blogId) {
    	  blogRepo.deleteById(blogId);
	}

}
