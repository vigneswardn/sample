package com.phase1.api.bizInterface;

import java.util.List;
import java.util.Set;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;
import com.phase1.api.dto.Invites;
import com.phase1.api.dto.Users;

public interface Blogger {

	public void addBlog(Blog blog);
	
	public Blog getBlog(Blog blog);
	
	public List<Blog> searchBlog(String searchContent);
	
	public void addComments(Blog blog);
	
	public Set<Comments> getComments(Blog blog);
	
	public String inviteUsers(Invites invites);
	
	public List<Blog> getAllFavourites(Users user);
}
