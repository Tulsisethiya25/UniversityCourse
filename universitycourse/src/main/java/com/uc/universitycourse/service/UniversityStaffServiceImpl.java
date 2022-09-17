package com.uc.universitycourse.service;

import java.util.List;




import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.UniversityStaffMember;
import com.uc.universitycourse.repository.UniversityStaffRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UniversityStaffServiceImpl implements IUniversityStaffService{
	
	private static final Logger log = LoggerFactory.getLogger( UniversityStaffServiceImpl.class);
	
	@Autowired
	private UniversityStaffRepository staffRepo;
	

	@Override
	public UniversityStaffMember addStaff(UniversityStaffMember staff) {
		log.info("Staff is added");
		return staffRepo.save(staff);
	}
	
	
		@Override
	public UniversityStaffMember updateStaff(UniversityStaffMember staff, int staffid) {
		log.info("Staff Updated");
		UniversityStaffMember ustaff=staffRepo.findById(staffid).get();
		if (Objects.nonNull(staff.getPassword())
	            && !"".equalsIgnoreCase(
	                staff.getPassword())) {
	            ustaff.setPassword(
	                staff.getPassword());
	        }
		if (Objects.nonNull(staff.getRole())
	            && !"".equalsIgnoreCase(
	                staff.getRole())) {
	            ustaff.setRole(
	                staff.getRole());
	        }
		
		return staffRepo.save(ustaff);
	}

	
	@Override
    public void removeStaff(int staffid) {
		log.info("Staff Removed");
		staffRepo.deleteById(staffid);	
	}
	
	@Override
	public Optional< UniversityStaffMember> getStaffById(int staffid) {
	      return staffRepo.findById(staffid);
	   }


	@Override
	public List<UniversityStaffMember> getAllStaffs() {
		return staffRepo.findAll();
	}	
	
	
	
	}
	


	
	







	
//

	
	



	
	

	