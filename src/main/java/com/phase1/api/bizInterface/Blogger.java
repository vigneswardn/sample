package com.phase1.api.bizInterface;

import java.util.List;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;

public interface Blogger {

	public void addBlog(Blog blog);
	
	public Blog getBlog(Blog blog);
	
	public List<Blog> searchBlog(String searchContent);
	
	public void addComments(Blog blog);
	
	public List<Comments> getComments(Blog blog);
}
