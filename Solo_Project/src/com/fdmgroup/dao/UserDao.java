package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.User;
import com.fdmgroup.model.UserType;

public class UserDao {
	private DbConnection connection;

	public UserDao() {
		super();
		connection = DbConnection.getInstance();
	}
	
	public void create(User user){
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		
	}
	public void delete(User user) {
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, user.getUserid());
		em.getTransaction().begin();
		em.remove(foundUser);
		em.getTransaction().commit();
		em.close();
	}
	
	public User findById(String id) {
		EntityManager em = connection.getEntityManager();
		User user = em.find(User.class, id);
		em.close();
		return user;
	}
	
	public List<User> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll", User.class);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}
	
	public List<User> findByType(UserType type) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByType", User.class);
		query.setParameter("type", type);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}
	
	public void update(User user){
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, user.getUserid());
		em.getTransaction().begin();
		
		if (user.getPassword() != null && !user.getPassword().equals(""))
			foundUser.setPassword(user.getPassword());
		if (user.getFirstname() != null && !user.getFirstname().equals(""))
			foundUser.setFirstname(user.getFirstname());
		if (user.getLastname() != null && !user.getLastname().equals(""))
			foundUser.setLastname(user.getLastname());
		if (user.getEmail() != null && !user.getEmail().equals(""))
			foundUser.setEmail(user.getEmail());

		em.getTransaction().commit();
		em.close();
	}
	
	
	
	
}
