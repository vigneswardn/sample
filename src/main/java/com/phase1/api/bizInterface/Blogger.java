package com.phase1.api.bizInterface;

import com.phase1.api.dto.Blog;

public interface Blogger {

	public void addBlog(Blog blog);
	
	public Blog getBlog(Blog blog);
	
	public Blog updateBlog(Blog blog);
}
