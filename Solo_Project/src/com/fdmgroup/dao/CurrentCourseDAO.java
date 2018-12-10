package com.fdmgroup.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Course;
import com.fdmgroup.model.CurrentCourse;
public class CurrentCourseDAO {
	private DbConnection connection;

	public CurrentCourseDAO() {
		super();
		connection = DbConnection.getInstance();
	}
	
	public void create(CurrentCourse current){
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(current);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(CurrentCourse current) {
		EntityManager em = connection.getEntityManager();
		CurrentCourse foundCourse = em.find(CurrentCourse.class, current.getName());
		em.getTransaction().begin();
		em.remove(foundCourse);
		em.getTransaction().commit();
		em.close();
	}
	
	public CurrentCourse findByName(String name) {
		EntityManager em = connection.getEntityManager();
		CurrentCourse course = em.find(CurrentCourse.class, name);
		em.close();
		return course;
	}
	
	public void AddTotal(CurrentCourse current){
		EntityManager em = connection.getEntityManager();
		CurrentCourse foundCourse = em.find(CurrentCourse.class, current.getName());
		em.getTransaction().begin();	
		if (foundCourse.getName() != null && !foundCourse.getName().equals(""))
			foundCourse.setTotal(foundCourse.getTotal()+1);
		em.getTransaction().commit();
		em.close();
	}
	public void DeleteTotal(CurrentCourse current){
		EntityManager em = connection.getEntityManager();
		CurrentCourse foundCourse = em.find(CurrentCourse.class, current.getName());
		em.getTransaction().begin();	
		if (foundCourse.getName() != null && !foundCourse.getName().equals(""))
			foundCourse.setTotal(foundCourse.getTotal()-1);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void AddYes(CurrentCourse current){
		EntityManager em = connection.getEntityManager();
		CurrentCourse foundCourse = em.find(CurrentCourse.class, current.getName());
		em.getTransaction().begin();	
		if (foundCourse.getName() != null && !foundCourse.getName().equals(""))
			foundCourse.setYes(foundCourse.getYes()+1);
		em.getTransaction().commit();
		em.close();
	}
	public void DeleteYes(CurrentCourse current){
		EntityManager em = connection.getEntityManager();
		CurrentCourse foundCourse = em.find(CurrentCourse.class, current.getName());
		em.getTransaction().begin();	
		if (foundCourse.getName() != null && !foundCourse.getName().equals(""))
			foundCourse.setYes(foundCourse.getYes()-1);
		em.getTransaction().commit();
		em.close();
	}
	public void AddNo(CurrentCourse current){
		EntityManager em = connection.getEntityManager();
		CurrentCourse foundCourse = em.find(CurrentCourse.class, current.getName());
		em.getTransaction().begin();	
		if (foundCourse.getName() != null && !foundCourse.getName().equals(""))
			foundCourse.setNo(foundCourse.getNo()+1);
		em.getTransaction().commit();
		em.close();
	}
	public void DeleteNo(CurrentCourse current){
		EntityManager em = connection.getEntityManager();
		CurrentCourse foundCourse = em.find(CurrentCourse.class, current.getName());
		em.getTransaction().begin();	
		if (foundCourse.getName() != null && !foundCourse.getName().equals(""))
			foundCourse.setNo(foundCourse.getNo()-1);
		em.getTransaction().commit();
		em.close();
	}
	
	public void ResetTotal(CurrentCourse current) {
		EntityManager em = connection.getEntityManager();
		CurrentCourse foundCourse = em.find(CurrentCourse.class, current.getName());
		em.getTransaction().begin();	
		if (foundCourse.getName() != null && !foundCourse.getName().equals(""))
			foundCourse.setTotal(0);
		em.getTransaction().commit();
		em.close();
	}
	public void ResetChoices(CurrentCourse current) {
		EntityManager em = connection.getEntityManager();
		CurrentCourse foundCourse = em.find(CurrentCourse.class, current.getName());
		em.getTransaction().begin();	
		if (foundCourse.getName() != null && !foundCourse.getName().equals(""))
			foundCourse.setYes(0);
			foundCourse.setNo(0);
		em.getTransaction().commit();
		em.close();
	}
	public List<CurrentCourse> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<CurrentCourse> query = em.createNamedQuery("ccourse.findAll", CurrentCourse.class);
		List<CurrentCourse> courses = query.getResultList();
		em.close();
		return courses;
	}
}
