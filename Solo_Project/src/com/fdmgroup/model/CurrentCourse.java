package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "CurrentCourse")
@NamedQueries({
	@NamedQuery(name = "ccourse.findAll", query = "SELECT c FROM CurrentCourse c"),
})
public class CurrentCourse {
	@Id
	@Column(name = "name",length = 40, nullable = false, unique = true)
	private String name;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "yes")
	private int yes;
	
	@Column(name = "no")
	private int no;

	
	public CurrentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CurrentCourse(String name) {
		super();
		this.name = name;
		this.total = 0;
		this.yes = 0;
		this.no = 0;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getYes() {
		return yes;
	}


	public void setYes(int yes) {
		this.yes = yes;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}

	
	
	
}
