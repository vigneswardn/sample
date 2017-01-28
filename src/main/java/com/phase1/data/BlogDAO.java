package com.phase1.data;

import com.phase1.api.dto.Blog;

public interface BlogDAO {
	
	public void create(Blog blog) ;
	
	public Blog update(Blog blog);
	
	public Blog read(Blog blog);
	
}
