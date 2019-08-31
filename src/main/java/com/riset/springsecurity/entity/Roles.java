package com.riset.springsecurity.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idroles;
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<Users> users;

	public Roles() {
		
	}
	
	public int getIdroles() {
		return idroles;
	}

	public void setIdroles(int idroles) {
		this.idroles = idroles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	
}
