package com.phase1.api.bizInterface;

import java.util.List;

import com.phase1.api.dto.Blog;

public interface Blogger {

	public void addBlog(Blog blog);
	
	public Blog getBlog(Blog blog);
	
	public List<Blog> searchBlog(String searchContent);
	
	public Blog updateBlog(Blog blog);
}
