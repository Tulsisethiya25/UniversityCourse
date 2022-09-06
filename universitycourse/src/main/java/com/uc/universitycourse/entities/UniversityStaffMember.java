package com.uc.universitycourse.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;




@Transactional
@Entity
@Table(name="UStaffs")
public class UniversityStaffMember {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int staffid;
	@NotNull
	private String password;
	@NotNull
	private String role;
	
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
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
