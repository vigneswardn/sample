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
		user.setUserName("vigneswardn24142");
		user.setPassword("vigneswardn");
		user.setFirstName("vigneswar");
		user.setLastName("lastname");
		user.setEmail("abc@gmail.com");
		user.setPhone("13132311");
		return user;
	}

	@Test
	public void testAddNewUsers() {
		System.out.println("testAddNewUsers - start");
		em = factory.createEntityManager();
		Users user = createUser();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		System.out.println("testAddNewUsers - end");
		assertTrue(user!=null);	
	}
	/*
	@Test
	public void testUpdateUsers() {
		System.out.println("testUpdateUsers - start");
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

		em.close();
		System.out.println("testUpdateUsers - end");
		assertTrue(user!=null);	
	}
	
	@Test
	public void testGetUsers() {
		System.out.println("testGetUsers - start");
		em = factory.createEntityManager();
		Users	user = createUser();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		Users user1 = em.find(Users.class, 1);
		em.close();
		System.out.println("testGetUsers - end");
		assertTrue(user1!=null);	
	}*/
	
}
