package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "Course")
@NamedQueries({
	@NamedQuery(name = "course.findAll", query = "SELECT c FROM Course c"),
	@NamedQuery(name = "course.findByP", query = "SELECT c FROM Course c WHERE c.professorid=:id"),
})

public class Course {
	@Id
	@Column(name = "name",length = 40, nullable = false, unique = true)
	private String name;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "professorid")
	private String professorid;

	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String name, String code, String professorid) {
		super();
		this.name = name;
		this.code = code;
		this.professorid = professorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProfessorid() {
		return this.professorid;
	}

	public void setProfessorid(String professorid) {
		this.professorid = professorid;
	}

	@Override
	public String toString() {
		return "[" + name + "," + code + "," + professorid + "]";
	}
	
	
}
