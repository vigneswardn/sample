package com.phase1.data;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;
import com.phase1.api.dto.Users;

public class BlogDAOImpl implements BlogDAO {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("blogger");
	
	public BlogDAOImpl() {
		super();
	}

	@Override
	public void create(Blog blog) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(blog);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Blog read(Blog blog) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Blog blogObj = em.find(Blog.class, blog.getBlogId());
		em.close();
		return blogObj;
	}

	@Override
	public List<Comments> readComments(Blog blog) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Blog blogObj = em.find(Blog.class, blog.getBlogId());
		List<Comments> comments = blogObj.getComments();
		em.close();
		return comments;
	}

	@Override
	public void create(Comments comments) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(comments);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Blog blog) {
		EntityManager em = factory.createEntityManager();
		Blog existingBlog = em.find(Blog.class,blog.getBlogId());
		if(blog.getComments() != null) {
			for(Comments comment: blog.getComments() ) {
				existingBlog.getComments().add(comment);	
			}
		}
		if(blog.getContent() != null) {
			existingBlog.setContent(blog.getContent());
		}
		if(blog.getModifiedDate() != null) {
			existingBlog.setModifiedDate(blog.getModifiedDate());
		} else {
			existingBlog.setModifiedDate(new Date());
		}
		if(blog.getTags() != null) {
			existingBlog.setTags(blog.getTags());
		}
		if(blog.getTitle() != null) {
			existingBlog.setTitle(blog.getTitle());
		}
		if(blog.getUsers() != null) {
			existingBlog.setUsers(blog.getUsers());
		}
		
		em.getTransaction().begin();
		em.merge(existingBlog);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Blog> readAllFavourites(Users user) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNativeQuery("select * from Blog a, Users b, users_blogs ab where a.isFavourite=true and b.userId=:userID1 and ab.userId=:userID2 and ab.blogId=a.blogId order ",Blog.class);
		query.setParameter("userID1", user.getUserId());
		query.setParameter("userID2", user.getUserId());
		List<Blog> blogs = (List<Blog>)query.getResultList();
		return blogs;
	}

	@Override
	public List<Blog> searchBlog(String searchContent) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNativeQuery("select * from blog where content like :searchContent1 or tags like :searchContent2",Blog.class);
		query.setParameter("searchContent1",searchContent);
		query.setParameter("searchContent2",searchContent);
		List<Blog> blogs = (List<Blog>)query.getResultList();
		return blogs;
		
	}

}
