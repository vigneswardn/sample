package com.phase1.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.phase1.api.dto.Users;

public class RegisterDAOTest {

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

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Users user = new Users();
		user.setUserName("vigneswardn3");
		user.setPassword("vigneswardn");
		user.setFirstName("vigneswar");
		user.setLastName("lastname");
		user.setEmail("abc@gmail.com");
		user.setPhone("13132311");
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testTotalUsers() {
	

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Users user = new Users();
		user.setUserName("vigneswardn4");
		user.setPassword("vigneswardn");
		user.setFirstName("vigneswar");
		user.setLastName("lastname");
		user.setEmail("abc@gmail.com");
		user.setPhone("13132311");
		em.persist(user);
		em.getTransaction().commit();
		
		
		List<Users> users = (List<Users>) em.createNativeQuery("select * from Users a",Users.class).getResultList();
		System.out.println("size: "+users.size());
		for(Users user1: users) {
			System.out.println(user1);
		}
		em.close();
		//assertTrue(users.size() == 1);	
	}
	
	@Test
	public void testSpecificUser() {
		@SuppressWarnings("unchecked")
		List<Users> users = (List<Users>) em.createNativeQuery("select * from Users a where userName='vigneswardn'").getResultList();
		//assertTrue(users.size()!=0);	
	}
	
/*	@Test
	public void testTotalBlogs() {
		@SuppressWarnings("unchecked")
		List<Blog> blogs = (List<Blog>) em.createNativeQuery("select * from Blog a ").getResultList();
	*/	
		/*for(Users user: users) {
			System.out.println(user.getUserName());
		}*/
	/*	System.out.println(blogs.size() );
		assertTrue(blogs.size() == 0);	
	}*/
	
}
