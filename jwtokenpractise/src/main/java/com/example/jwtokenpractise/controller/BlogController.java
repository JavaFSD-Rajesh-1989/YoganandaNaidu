package com.example.jwtokenpractise.controller;

import com.example.jwtokenpractise.entity.Blog;
import com.example.jwtokenpractise.entity.User; // Import User entity
import com.example.jwtokenpractise.service.BlogService;
import com.example.jwtokenpractise.service.UserService; // Import UserService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService; // Inject UserService

    @PostMapping("/create")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        // Get the authenticated user from the SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Get the username from the authentication

        // Find the user by username
        User user = userService.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        // Set the author (user) on the blog
        blog.setAuthor(user);
        
        return ResponseEntity.ok(blogService.createBlog(blog));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.getBlogById(id);
        return blogOptional.map(ResponseEntity::ok)
                           .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        // Get the authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        User user = userService.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("User not found"));
        
        // Set the author (user) on the blog
        blog.setAuthor(user);
        
        return ResponseEntity.ok(blogService.updateBlog(id, blog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        boolean isDeleted = blogService.deleteBlog(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
