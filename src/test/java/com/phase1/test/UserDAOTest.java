package com.phase1.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Users;

import static org.junit.Assert.assertTrue;

public class UserDAOTest {

	static EntityManagerFactory factory;
	static EntityManager em;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("blogger");
		em = factory.createEntityManager();
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

	@Test
	public void testAddNewUsers() {
		em = factory.createEntityManager();
		Users user = createUser();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
//		List<Users> users = (List<Users>) em.createNativeQuery("select * from Users a",Users.class).getResultList();
		em.close();
		assertTrue(1==1);	
	}
	
	@Test
	public void testUpdateUsers() {
		em = factory.createEntityManager();

		//create user first
		Users	user = createUser();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		user = em.find(Users.class, 1);
		em.getTransaction().begin();
		user.setPassword("12344");
		em.merge(user);
		em.getTransaction().commit();

		//		List<Users> users = (List<Users>) em.createNativeQuery("select * from Users a",Users.class).getResultList();
		em.close();
		assertTrue(1==1);	
	}
	
	@Test
	public void testGetUsers() {
		em = factory.createEntityManager();
		Users user = em.find(Users.class, 1);
		em.close();
		assertTrue(1==1);	
	}
	
}
