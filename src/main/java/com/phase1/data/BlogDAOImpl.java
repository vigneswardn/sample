package com.phase1.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
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
		Blog blogObj = em.find(Blog.class, blog.getBlogId());
		return blogObj;
	}

	@Override
	public Set<Comments> readComments(Blog blog) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Blog blogObj = em.find(Blog.class, blog.getBlogId());
		Set<Comments> comments = blogObj.getComments();
		em.close();
		return comments;
	}

	@Override
	public void create(Comments comments) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		comments.setCreatedDate(new Date());
		em.persist(comments);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Blog blog) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		blog.setModifiedDate(new Date());
		em.merge(blog);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Blog> readAllFavourites(Users user) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNativeQuery("select a.* from blog a where blogid in (select ab.blogId from users_blogs ab where ab.userid =:userID) and isfavourite=true order by 1",Blog.class);
		query.setParameter("userID", user.getUserId());
		List<Blog> blogs = (List<Blog>)query.getResultList();
		em.close();
		return blogs;
	}

	@Override
	public List<Blog> searchBlog(String searchContent) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNativeQuery("select * from blog where content LIKE :searchContent OR title LIKE :searchContent",Blog.class);
		query.setParameter("searchContent","%"+searchContent+"%");
		List<Blog> blogs = (List<Blog>)query.getResultList();
		return blogs;
		
	}

}
