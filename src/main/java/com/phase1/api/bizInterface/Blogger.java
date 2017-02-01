package com.phase1.api.bizInterface;

import java.util.List;
import java.util.Set;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;
import com.phase1.api.dto.Invites;
import com.phase1.api.dto.Users;
import com.phase1.api.exception.BloggerException;

public interface Blogger {

	public void addBlog(Blog blog) throws BloggerException;
	
	public Blog getBlog(Blog blog) throws BloggerException;
	
	public List<Blog> searchBlog(String searchContent) throws BloggerException;
	
	public void addComments(Blog blog) throws BloggerException;
	
	public Set<Comments> getComments(Blog blog) throws BloggerException;
	
	public String inviteUsers(Invites invites) throws BloggerException;
	
	public List<Blog> getAllFavourites(Users user) throws BloggerException;
	
	public Set<Blog> getBlogs(Users user) throws BloggerException;
}
