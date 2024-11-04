package com.example.paginationdemo.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "blogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long blogId; 
	
	private String blogName; 
	
	private String blogContent; 
	
	private LocalDate createdAt; 
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
	private User user;

}
