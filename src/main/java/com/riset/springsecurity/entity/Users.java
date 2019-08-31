package com.riset.springsecurity.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusers;
	private String name;
	private String email;
	private String password;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "users_roles",
	joinColumns = {@JoinColumn(name = "idusers", referencedColumnName = "idusers")},
	inverseJoinColumns = {@JoinColumn(name = "idroles", referencedColumnName = "idroles")})
	private List<Roles> roles;
	
	public Users() {
		
	}
	
	public int getIdusers() {
		return idusers;
	}
	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	
	
}
