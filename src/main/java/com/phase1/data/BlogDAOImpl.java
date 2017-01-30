package com.phase1.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;

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
		em.getTransaction().begin();
		em.merge(blog);
		em.getTransaction().commit();
		em.close();
	}

}
