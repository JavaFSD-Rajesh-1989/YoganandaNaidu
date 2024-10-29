package com.case_study_practise.model;

public class Blog {

	private long blogId;
	
	private String title;
	
	private String content;
	
	private String author;
	
	private Blog() {
		
	}
	
	private Blog(long blogId, String title, String content, String author) {
		this.blogId = blogId;
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
