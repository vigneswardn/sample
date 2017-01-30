package com.phase1.biz;

import java.util.Date;
import java.util.List;

import com.phase1.api.bizInterface.Blogger;
import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;
import com.phase1.api.dto.Users;
import com.phase1.data.BlogDAO;
import com.phase1.data.BlogDAOImpl;
import com.phase1.data.UserDAO;
import com.phase1.data.UserDAOImpl;

public class BloggerImpl implements Blogger {

	BlogDAO blogDAO;
	UserDAO userDAO;
	
	public BloggerImpl() {
		blogDAO = new BlogDAOImpl();
		userDAO = new UserDAOImpl();
	}

	@Override
	public void addBlog(Blog blog) {
		
		// add Blog
		blog.setCreateDate(new Date());
		blog.setModifiedDate(null);
		blogDAO.create(blog);
		// get User ID from UI
		Users user = blog.getUsers().get(0); 
		// get complete user details
		user = userDAO.readById(user);
		user.getBlogs().add(blog);
		// update user with blog info
		userDAO.update(user);
		
	}

	@Override
	public Blog getBlog(Blog blog) {
		blog = blogDAO.read(blog);
		return blog;
	}

	@Override
	public List<Blog> searchBlog(String searchContent) {
		
		return null;
	}

	@Override
	public void addComments(Blog blog) {
		Comments comments = blog.getComments().get(0);
		// add Comment
		blogDAO.create(comments);
		// map comment to blog table
		Blog existingBlog = blogDAO.read(blog);
		existingBlog.getComments().add(comments);
		blogDAO.update(existingBlog);
		
	}

	@Override
	public List<Comments> getComments(Blog blog) {
		List<Comments> comments = blogDAO.readComments(blog);
		return comments;
	}

}
