package com.phase1.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;
import com.phase1.api.dto.Users;

public class BlogDAOTest {

	public BlogDAOTest() {
		// TODO Auto-generated constructor stub
	}
	static EntityManagerFactory factory;
	EntityManager em;
	
	@Before
	public void before() {
		em = factory.createEntityManager();
		em.getTransaction().begin();
	}
	
	@After
	public void after() {
		if (em.isOpen() && em.getTransaction().isActive())
			em.getTransaction().commit();
		if (em.isOpen())
			em.close();
	}

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("blogger");
		
	}
	
	private static Users createUser() {
		Users user = new Users();
		user.setUserName("vigneswardn3");
		user.setPassword("vigneswardn");
		user.setFirstName("vigneswar");
		user.setLastName("lastname");
		user.setEmail("abc@gmail.com");
		user.setPhone("13132311");
		return user;
	}
	
	private static Blog createBlog() {
		Blog blog = new Blog();
		blog.setTitle("Title");
		blog.setContent("wasdgasg");
		return blog;
	}
	
	/*@Test
	public void testCreateBlogs() {
		em = factory.createEntityManager();
		Users user = createUser();
		Blog blog = createBlog();
		
		em.getTransaction().begin();
		em.persist(blog);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		em.getTransaction().begin();
		Users user1 = em.find(Users.class, 1);
		user1.getBlogs().add(blog);
		em.merge(user1);
		em.getTransaction().commit();
		em.close();
		assertTrue(true);	
	}*/
	
	
	/*@Test
	public void testUpdateBlogs() {
		em = factory.createEntityManager();
		
		//create blog first
		Blog blog = createBlog();
		em.getTransaction().begin();
		em.persist(blog);
		em.getTransaction().commit();
		
		blog = em.find(Blog.class, 1);
		blog.setCreatedBy("user");

		em.getTransaction().begin();
		em.merge(blog);
		em.getTransaction().commit();
		em.close();
		assertTrue(true);	
	}*/
	
/*	@Test
	public void testGetBlogs() {
		em = factory.createEntityManager();
		Users user = createUser();
		Blog blog = createBlog();
		em.getTransaction().begin();
		em.persist(blog);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		em.getTransaction().begin();
		Users user1 = em.find(Users.class, 1);
		user1.getBlogs().add(blog);
		em.merge(user1);
		em.getTransaction().commit();
		
		Users user2 = em.find(Users.class, 1);
		List<Blog> blogs = user2.getBlogs();
		System.out.println("***********************");
		System.out.println(blogs);
		System.out.println("***********************");
		em.close();
		assertTrue(true);
		
	}*/
	
	/*@Test
	public void testAddMultipleBlogs() {
		em = factory.createEntityManager();
		//create user first
		Users user = createUser();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		//create blog 1
		Blog blog1 = createBlog();
		em.getTransaction().begin();
		em.persist(blog1);
		em.getTransaction().commit();

		//create blog 2
		Blog blog2 = createBlog();
		em.getTransaction().begin();
		em.persist(blog2);
		em.getTransaction().commit();

		em.getTransaction().begin();
		user = em.find(Users.class, 1);
		user.getBlogs().add(blog1);
		user.getBlogs().add(blog2);
		em.merge(user);
		em.getTransaction().commit();
		em.close();
		assertTrue(true);

	}*/
	
	/*@Test
	public void testAddUserViaBlog() {
		em = factory.createEntityManager();
		//create user first
		Users user = createUser();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		//create blog 1
		Blog blog1 = createBlog();
		List<Users> users = new ArrayList<Users>();
		user.setUserId(1);
		users.add(user);
		blog1.setUsers(users);
		em.getTransaction().begin();
		em.persist(blog1);
		em.getTransaction().commit();

		Users user1 = blog1.getUsers().get(0);
		em.getTransaction().begin();
		user1.getBlogs().add(blog1);
		em.merge(user1);
		em.getTransaction().commit();
		//create blog 2
		Blog blog2 = createBlog();
		em.getTransaction().begin();
		em.persist(blog2);
		em.getTransaction().commit();

		em.getTransaction().begin();
		user = em.find(Users.class, 1);
		user.getBlogs().add(blog1);
		user.getBlogs().add(blog2);
		em.merge(user);
		em.getTransaction().commit();
		em.close();
		assertTrue(true);

	}*/
	
	@Test
	public void testAddComments() {
		em = factory.createEntityManager();
		Users user = createUser();
		Blog blog = createBlog();
		em.getTransaction().begin();
		em.persist(blog);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		em.getTransaction().begin();
		Users user1 = em.find(Users.class, 1);
		user1.getBlogs().add(blog);
		em.merge(user1);
		em.getTransaction().commit();
		
		Users user2 = em.find(Users.class, 1);
		List<Blog> blogs = user2.getBlogs();
		
		em.getTransaction().begin();
		Comments comment = new Comments();
		comment.setComment("first");
		comment.setCreatedBy("vnagarat");
		comment.setCreatedDate(new Date());
		em.persist(comment);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		List<Comments> comments = new ArrayList<Comments>();
		comments.add(comment);
		blog.setComments(comments);
		em.merge(blog);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Users user10 = em.find(Users.class, 1);
		System.out.println(user10);
		List<Blog> blogs10 = user10.getBlogs();
		System.out.println(blogs10.get(0));
		List<Comments> comments10 = blogs10.get(0).getComments();
		System.out.println(comments10.get(0));
		
		em.close();
		assertTrue(true);
		
	}
	
}
