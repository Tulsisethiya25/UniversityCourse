package com.uc.universitycourse.entities;




import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="ustaffs")
public class UniversityStaffMember {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Staffid;
	@NotNull
	private String Password;
	@NotNull
	private String Role;
	

	
	public UniversityStaffMember() {
		
	}

	public UniversityStaffMember(int staffid, String password, String role) {
		super();
		Staffid = staffid;
		Password = password;
		Role = role;
	}

	public int getStaffid() {
		return Staffid;
	}

	public void setStaffid(int staffid) {
		Staffid = staffid;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	
	

	

}
