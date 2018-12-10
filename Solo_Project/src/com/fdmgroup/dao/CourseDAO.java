package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Course;
import com.fdmgroup.model.User;

import oracle.net.aso.i;

public class CourseDAO {
	private DbConnection connection;

	public CourseDAO() {
		super();
		connection = DbConnection.getInstance();
	}
	
	public void create(Course course){
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Course course) {
		EntityManager em = connection.getEntityManager();
		Course foundCourse = em.find(Course.class, course.getName());
		em.getTransaction().begin();
		em.remove(foundCourse);
		em.getTransaction().commit();
		em.close();
	}
	
	public Course findByName(String name) {
		EntityManager em = connection.getEntityManager();
		Course course = em.find(Course.class, name);
		em.close();
		return course;
	}
	
	public List<Course> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Course> query = em.createNamedQuery("course.findAll", Course.class);
		List<Course> courses = query.getResultList();
		em.close();
		return courses;
	}
	
	public List<Course> findByProfessor(String id) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Course> query = em.createNamedQuery("course.findByP", Course.class);
		query.setParameter("id", id);
		List<Course> courses = query.getResultList();
		em.close();
		return courses;
	}
}
