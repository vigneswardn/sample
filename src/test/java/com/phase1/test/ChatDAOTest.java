package com.phase1.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;

import com.phase1.api.dto.Chat;

public class ChatDAOTest {

	static EntityManagerFactory factory;
	static EntityManager em;

	public ChatDAOTest() {
		super();
	}

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("blogger");
		em = factory.createEntityManager();
	}

	@Test
	public void testAddChats() {
		System.out.println("testAddChats - start");
		em = factory.createEntityManager();
		Chat chat1 = new Chat();
		chat1.setCreatedBy("vnagarat");
		chat1.setCreatedDate(new Date());
		chat1.setMessage("My first chat");
		
		em.getTransaction().begin();
		em.persist(chat1);
		em.getTransaction().commit();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Chat chat2 = new Chat();
		chat2.setCreatedBy("vnagarat");
		chat2.setCreatedDate(new Date());
		chat2.setMessage("My second chat");
		Timer timer = new Timer();
		
		em.getTransaction().begin();
		em.persist(chat2);
		em.getTransaction().commit();
		
		EntityManager em = factory.createEntityManager();
		Query query = em.createNativeQuery("select * from Chat a order by createdDate desc",Chat.class);
		List<Chat> chats = (List<Chat>) query.getResultList();
		System.out.println(chats);
		em.close();
		System.out.println("testAddChats - end");
		assertTrue(chats!=null);	
	}
	
}
