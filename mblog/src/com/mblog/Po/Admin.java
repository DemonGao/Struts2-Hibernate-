package com.mblog.Po;

import javax.persistence.*;

@Entity
public class Admin {

	private int id;
	private String username;
	private String password;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   //@GeneratedValue  一样
	@Column(length=11,unique=true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
