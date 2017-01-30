package com.phase1.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.phase1.api.dto.Users;

public class UserDAOImpl implements UserDAO {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("blogger");
	
	public UserDAOImpl() {
		super();
	}

	@Override
	public void create(Users user) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Users update(Users user) {
		EntityManager em = factory.createEntityManager();
		Users existingUser = em.find(Users.class,user.getUserId());
		if(user.getEmail() == null) {
			user.setEmail(existingUser.getEmail());
		}
		if(user.getFirstName() == null) {
			user.setFirstName(existingUser.getFirstName());
		}
		if(user.getLastName() == null) {
			user.setLastName(existingUser.getLastName());
		}
		if(user.getPassword() == null) {
			user.setPassword(existingUser.getPassword());
		}
		if(user.getPhone() == null) {
			user.setPhone(existingUser.getPhone());
		}
		if(user.getUserName() == null) {
			user.setUserName(existingUser.getUserName());
		}
		em.getTransaction().begin();
		user = em.merge(user);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public Users readById(Users user) {
		EntityManager em = factory.createEntityManager();
		user = em.find(Users.class, user.getUserId());
		em.close();
		return user;
	}

	@Override
	public Users readByName(Users user) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createNativeQuery("select userId from Users a where userName=:uName and password=:pwd",Users.class);
		query.setParameter("uName", user.getUserName());
		query.setParameter("pwd",user.getPassword());
		Users userObj = (Users) query.getSingleResult();
		em.close();
		return userObj;
	}


}
