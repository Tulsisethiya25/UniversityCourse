package com.uc.universitycourse.dto;



public class UniversityStaffMemberDTO {
	private int Staffid;
	private String Password;
	private String Role;
	
	public UniversityStaffMemberDTO() {
		
	}
	
	public UniversityStaffMemberDTO(int staffid, String password, String role) {
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
