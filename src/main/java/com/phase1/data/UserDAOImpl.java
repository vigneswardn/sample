package com.phase1.data;

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
			existingUser.setEmail(user.getEmail());
		}
		if(user.getFirstName() == null) {
			existingUser.setFirstName(user.getFirstName());
		}
		if(user.getLastName() == null) {
			existingUser.setLastName(user.getLastName());
		}
		if(user.getPassword() == null) {
			existingUser.setPassword(user.getPassword());
		}
		if(user.getPhone() == null) {
			existingUser.setPhone(user.getPhone());
		}
		if(user.getUserName() == null) {
			existingUser.setUserName(user.getUserName());
		}
		em.getTransaction().begin();
		existingUser = em.merge(existingUser);
		em.getTransaction().commit();
		em.close();
		return existingUser;
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

	@Override
	public Users readyByEmail(String email) {
		EntityManager em = factory.createEntityManager();
		Users user = em.find(Users.class, email);
		return user;
	}


}
