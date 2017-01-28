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
		//Add User:
	//	EntityManager em = factory.createEntityManager();
	//	em.getTransaction().begin();
		Users user = new Users();
		user.setUserName("vigneswardn4");
		user.setPassword("vigneswardn");
		user.setFirstName("vigneswar");
		user.setLastName("lastname");
		user.setEmail("abc@gmail.com");
		user.setPhone("13132311");
	//	em.persist(user);
	//	em.getTransaction().commit();
	//	System.out.println("Printing user before blog entry: "+user);
		
		List<Users> users = new ArrayList<Users>();
		users.add(user);
		
		//Add Blog for a user
		//EntityManager em = factory.createEntityManager();
	//	em.getTransaction().begin();
		String[] tags = {"sample","tech"};
		Blog blog = new Blog("My First Blog","adasdgasdga",new Date(),new Date(),"vnagarat",false,tags);
	//	em.persist(blog); // persist blog
		List<Blog> blogs = new ArrayList<Blog>();
		blogs.add(blog);
		
		user.setBlogs(blogs);
		blog.setUsers(users);
		
	//	em.getTransaction().commit();
		
	//	System.out.println("Printing blog entry: "+blog);
	
	//	em.getTransaction().begin();
	
	//	user.setBlogs(blogs);
	//	em.persist(user); // update same user with blog info
	//	em.getTransaction().commit();
		//System.out.println("Printing user after blog entry: "+user);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		System.out.println("Printing user: "+user);
		System.out.println("Printing blog: "+blog);
	}
	

	@Test
	public void testTotalBlogs() {
		Query query = em.createNativeQuery("select * from Blog a ", Blog.class);
		List<Blog> blogs = (List<Blog>) query.getResultList();
		//Blog blog = (Blog) blogs.get(0);
		//System.out.println(blog);
		//System.out.println(blogs.size() );
		Query query1 = em.createNativeQuery("select * from Users a ", Users.class);
		List<Users> users = (List<Users>) query1.getResultList();
		for(Users user:users) {
		//	System.out.println(user);
		}
		assertTrue(true);	
	}
	
}
