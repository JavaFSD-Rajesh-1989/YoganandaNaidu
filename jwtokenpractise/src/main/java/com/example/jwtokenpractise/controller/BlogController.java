package com.example.jwtokenpractise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.example.jwtokenpractise.entity.Blog;
import com.example.jwtokenpractise.entity.User;
import com.example.jwtokenpractise.service.BlogService;
import com.example.jwtokenpractise.service.UserService;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog, @AuthenticationPrincipal UserDetails userDetails) {
        User author = userService.findByUsername(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        blog.setAuthor(author);
        Blog savedBlog = blogService.createBlog(blog);
        return ResponseEntity.ok(savedBlog);
    }


    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Blog>> getBlogsByUser(@PathVariable Long userId) {
        User user = userService.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Blog> blogs = blogService.getAllBlogsByUser(user);
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlogs(@RequestParam String query) {
        List<Blog> blogs = blogService.searchBlogs(query);
        return ResponseEntity.ok(blogs);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blogDetails) {
        Blog updatedBlog = blogService.updateBlog(id, blogDetails);
        return ResponseEntity.ok(updatedBlog);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }
}
