package com.uc.universitycourse.service;

import java.util.List;

import java.util.Optional;

import com.uc.universitycourse.entities.UniversityStaffMember;



public interface IUniversityStaffService {
	
	public UniversityStaffMember addStaff(UniversityStaffMember staff);
	public UniversityStaffMember updateStaff(UniversityStaffMember staff);
	public Optional<UniversityStaffMember> getStaffById(int staffid);
	public void removeStaff(int staffid);
	public List<UniversityStaffMember> viewAllStaffs();
		
}
	
	
	
	
	


