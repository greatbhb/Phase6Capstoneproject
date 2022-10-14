package com.aadhaar.bean;

import java.beans.JavaBean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String emailid;
	private String password,role;
	private String phno;
	
	public User() {
		super();
	}
	public User(String emailid, String password, String role, String phno) {
		super();
		this.emailid = emailid;
		this.password = password;
		this.role = role;
		this.phno = phno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "User [emailid=" + emailid + ", password=" + password + ", role=" + role + ", phno=" + phno + "]";
	}
	
	

}
