package com.phase1.data;

import java.util.List;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;

public interface BlogDAO {
	
	public void create(Blog blog) ;
	
	public Blog read(Blog blog);

	public List<Comments> readComments(Blog blog);
	
	public void create(Comments comments);
	
	public void update(Blog blog);
}
