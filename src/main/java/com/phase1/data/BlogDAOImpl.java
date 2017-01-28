package com.phase1.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.phase1.api.dto.Blog;

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
	public Blog update(Blog blog) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		blog = em.merge(blog);
		em.getTransaction().commit();
		em.close();
		return blog;
	}

	@Override
	public Blog read(Blog blog) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Blog blogObj = em.find(Blog.class, blog.getBlogId());
		em.getTransaction().commit();
		em.close();
		return blogObj;
	}

}
