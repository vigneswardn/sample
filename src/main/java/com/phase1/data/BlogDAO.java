package com.phase1.data;

import java.util.List;
import java.util.Set;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;
import com.phase1.api.dto.Users;

public interface BlogDAO {
	
	public void create(Blog blog) ;
	
	public Blog read(Blog blog);

	public Set<Comments> readComments(Blog blog);
	
	public void create(Comments comments);
	
	public void update(Blog blog);
	
	public List<Blog> readAllFavourites(Users user);
	
	public List<Blog> searchBlog(String searchContent);
}
