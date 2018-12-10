package com.fdmgroup.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "APPUSER")
@NamedQueries({
	@NamedQuery(name = "user.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "user.findByType", query = "SELECT u FROM User u where u.type = :type")
})
public class User {

	@Id
	@Column(name = "userid",length = 20, nullable = false, unique = true)
	private String userid;
	
	@Column(name = "password", length = 40, nullable = false)
	private String password;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="type",nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType type;

	public User() {
		super();
	}

	public User(String userid, String password, String firstname, String lastname,String email,UserType usertype) {
		super();
		this.userid = userid;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email=email;
		this.type=usertype;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userid != other.userid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", type=" + type + "]";
	}
	
}
