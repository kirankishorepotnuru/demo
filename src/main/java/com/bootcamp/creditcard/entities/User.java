package com.bootcamp.creditcard.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	private int userId;
	
	@NotEmpty(message = "password not be empty")
	private String password;
	
	@NotEmpty(message = "role not be empty")
	private String role;
	
	private boolean isActive;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Customer customer;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
}
