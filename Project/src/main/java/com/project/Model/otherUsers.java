package com.project.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name="otherusers")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class otherUsers {
	@Id
	@Column(name="email")
	String email;
	@Column(name="username")
	String name;
	@Column(name="password")
	String password;
	@Column(name="role")
	String role;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public otherUsers() {
		// TODO Auto-generated constructor stub
	}
	
}

