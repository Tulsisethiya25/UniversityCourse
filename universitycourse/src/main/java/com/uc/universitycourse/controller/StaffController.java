package com.uc.universitycourse.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.uc.universitycourse.dto.UniversityStaffMemberDTO;
import com.uc.universitycourse.entities.UniversityStaffMember;
import com.uc.universitycourse.service.IUniversityStaffService;



@RestController
public class StaffController {
	
	@Autowired
    private IUniversityStaffService ustaffservice;	
   


	@PostMapping(value = "addStaff")
	public ResponseEntity<UniversityStaffMember> addStaff(@RequestBody UniversityStaffMemberDTO staffdto) {
		UniversityStaffMember staff = new UniversityStaffMember();
		staff.setStaffid(staffdto.getStaffid());
		staff.setPassword(staffdto.getPassword());
		staff.setRole(staffdto.getRole());
		UniversityStaffMember addinfo = ustaffservice.addStaff(staff);
		 return new ResponseEntity<>(addinfo ,HttpStatus.CREATED); 
	
	}

	@PutMapping(value = "UpdateStaff")
	public ResponseEntity<UniversityStaffMember> updateStaff(@RequestBody UniversityStaffMemberDTO staffdto) {
		UniversityStaffMember staff = new UniversityStaffMember();
		staff.setStaffid(staffdto.getStaffid());
		staff.setPassword(staffdto.getPassword());
		staff.setRole(staffdto.getRole());
		UniversityStaffMember updateinfo = ustaffservice.addStaff(staff);
		 return new ResponseEntity<>(updateinfo ,HttpStatus.CREATED); 	
	}

	@GetMapping("/viewstaff/{staffid}")
	   public Optional<UniversityStaffMember> viewStaff(@PathVariable("staffid") int staffid) {
		return ustaffservice.getStaffById(staffid);   
	   }

	@DeleteMapping(value ="removeStaff")
	public String deleteStaff(@RequestBody Integer staffid) {
		ustaffservice.removeStaff(staffid);
		return "Staff Removed";
	}
	
	@GetMapping(value = "viewAllStaff")
	public List<UniversityStaffMember> viewAllStaff(){	
    return ustaffservice.viewAllStaffs();
		
	}
	
	
	
}
	



















	

	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	

