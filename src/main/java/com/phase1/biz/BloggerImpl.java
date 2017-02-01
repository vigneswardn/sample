package com.phase1.biz;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.phase1.api.bizInterface.Blogger;
import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;
import com.phase1.api.dto.Invites;
import com.phase1.api.dto.Users;
import com.phase1.api.exception.BloggerException;
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
		Set<Users> usersSet = blog.getUsers();
		for(Users user: usersSet) {
			//Users user = blog.getUsers().get(0); 
			// get complete user details
			user = userDAO.readById(user);
			user.getBlogs().add(blog);
			// update user with blog info
			userDAO.updateBlogForUser(user);
		}
	}

	@Override
	public Blog getBlog(Blog blog) {
		blog = blogDAO.read(blog);
		return blog;
	}
	
	

	@Override
	public List<Blog> searchBlog(String searchContent) {
		List<Blog> blogs = blogDAO.searchBlog(searchContent);
		return blogs;
	}

	@Override
	public void addComments(Blog blog) {
		
		Set<Comments> comments = blog.getComments();
		
		for(Comments comment: comments) {
			// add Comment
			blogDAO.create(comment);
		}
		// map comment to blog table
		Blog existingBlog = blogDAO.read(blog);
		existingBlog.getComments().addAll(comments);
		blogDAO.update(existingBlog);
	}

	@Override
	public Set<Comments> getComments(Blog blog) {
		Set<Comments> comments = blogDAO.readComments(blog);
		return comments;
	}

	@Override
	public String inviteUsers(Invites invites) {
		Users invitedUser = null;
		//Get Actual User details
		Integer userId = invites.getUserId();
		Users actualUser = new Users();
		actualUser.setUserId(userId);
		actualUser = userDAO.readById(actualUser);
		Set<Blog> blogs = actualUser.getBlogs();
		for(Blog blog:blogs) {
			for(String email: invites.getEmails()) {
				invitedUser = userDAO.readyByEmail(email);
				if(invitedUser != null) {
					invitedUser.getBlogs().add(blog);
					userDAO.update(invitedUser);
				}
			}
		}
		
		return "success";
	}

	@Override
	public List<Blog> getAllFavourites(Users user) {
		List<Blog> blogs = blogDAO.readAllFavourites(user);
		return blogs;
	}

	@Override
	public Set<Blog> getBlogs(Users user) throws BloggerException {
		Users existingUser = userDAO.readById(user);
		Set<Blog> blogs = existingUser.getBlogs();
		return blogs;
	}

}
