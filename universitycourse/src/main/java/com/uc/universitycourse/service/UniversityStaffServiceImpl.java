package com.uc.universitycourse.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.UniversityStaffMember;
import com.uc.universitycourse.repository.ICourseRepository;
import com.uc.universitycourse.repository.UniversityStaffRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UniversityStaffServiceImpl implements IUniversityStaffService{
	private static final Logger log = LoggerFactory.getLogger( UniversityStaffServiceImpl.class);
	@Autowired
	private UniversityStaffRepository staffrepo;
	@Autowired
	private ICourseRepository icourseRepository;



	@Override
	public UniversityStaffMember addStaff(UniversityStaffMember staff) {
		log.info("Staff added");
		return staffrepo.save(staff);
	}
	
	@Override
	public UniversityStaffMember updateStaff(UniversityStaffMember staff) {
		log.info("Staff Updated");
		return staffrepo.save(staff);
	}
	
	@Override
    public void removeStaff(int staffid) {
		log.info("Staff Removed");
		staffrepo.deleteById(staffid);	
	}
	@Override
	public Optional<UniversityStaffMember> getStaffById(int staffid) {
		 return staffrepo.findById(staffid);
	   }

	@Override
	public List<UniversityStaffMember> viewAllStaffs() {
		return (List<UniversityStaffMember>) staffrepo.findAll();
	}	
	
	
}
	
	
	
	
	
	
	


	
	



	
	

	