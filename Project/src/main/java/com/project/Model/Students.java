package com.project.Model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="students")

public class Students {
	
	
	
	public Students() {
		super();
	}
	
	
	@Id
	@Column(name="rollno")
	String rollno;
	@Column(name="username")
	String name;
	@Column(name="password")
	String password;
	@Column(name="role",nullable = true)
	String role;
	public Students(String rollno, String name, String password, String role) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
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
	


}
