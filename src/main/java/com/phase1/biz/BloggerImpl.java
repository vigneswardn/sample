package com.phase1.biz;

import java.util.Date;
import java.util.List;

import com.phase1.api.bizInterface.Blogger;
import com.phase1.api.dto.Blog;
import com.phase1.data.BlogDAO;
import com.phase1.data.BlogDAOImpl;

public class BloggerImpl implements Blogger {

	BlogDAO blogDAO;
	
	public BloggerImpl() {
		blogDAO = new BlogDAOImpl();
	}

	@Override
	public void addBlog(Blog blog) {
		blog.setCreateDate(new Date());
		blog.setModifiedDate(null);
		blogDAO.create(blog);

	}

	@Override
	public Blog getBlog(Blog blog) {
		blog = blogDAO.read(blog);
		return blog;
	}

	@Override
	public Blog updateBlog(Blog blog) {
		blog.setModifiedDate(new Date());
		blog = blogDAO.update(blog);
		return blog;
	}

	@Override
	public List<Blog> searchBlog(String searchContent) {
		
		return null;
	}

}
