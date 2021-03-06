package com.phase1.data;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.phase1.api.dto.Chat;

public class ChatDAOImpl implements ChatDAO {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("blogger");
	
	public ChatDAOImpl() {
		super();
	}

	@Override
	public void create(Chat chatMsg) {
		EntityManager em = factory.createEntityManager();
		chatMsg.setCreatedDate(new Date());
		em.getTransaction().begin();
		em.persist(chatMsg);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Chat> getChats() {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNativeQuery("select * from Chat a order by 1 ",Chat.class);
		List<Chat> chats = (List<Chat>) query.getResultList();
		em.close();
		return chats;
	}

}
