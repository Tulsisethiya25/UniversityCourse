package com.uc.universitycourse.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uc.universitycourse.dto.UniversityStaffMemberDTO;
import com.uc.universitycourse.entities.UniversityStaffMember;
import com.uc.universitycourse.exception.StaffNotFoundException;
import com.uc.universitycourse.service.UniversityStaffServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;




@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StaffController {
	
	@Autowired
    private UniversityStaffServiceImpl ustaffService;	
   

	
	@PostMapping("/staffs")
	public ResponseEntity<UniversityStaffMember> addStaff(@Valid @RequestBody UniversityStaffMemberDTO staffdto) {
		
		UniversityStaffMember staff = new UniversityStaffMember();
		staff.setStaffid(staffdto.getStaffid());
		staff.setPassword(staffdto.getPassword());
		staff.setRole(staffdto.getRole());
		UniversityStaffMember addinfo = ustaffService.addStaff(staff);
		 return new ResponseEntity<>(addinfo ,HttpStatus.CREATED); 
		
	}
	@GetMapping("/staffs/{staffid}")
	   public ResponseEntity<UniversityStaffMember> getStaffById(@PathVariable("staffid") int staffid) {
		UniversityStaffMember staff = ustaffService.getStaffById(staffid).orElseThrow(()-> new StaffNotFoundException("Staff not exist with this id:" + staffid)); 
		  return ResponseEntity.ok(staff);
	   }
	@PutMapping("/staffs/{staffid}")
	public ResponseEntity<UniversityStaffMember> updateStaff(@PathVariable int staffid,@RequestBody UniversityStaffMemberDTO staffdto) {
		UniversityStaffMember staff = new UniversityStaffMember();
		staff.setStaffid(staffdto.getStaffid());
		staff.setPassword(staffdto.getPassword());
		staff.setRole(staffdto.getRole());
		UniversityStaffMember updateinfo = ustaffService.updateStaff(staff,staffid);
		 return new ResponseEntity<>(updateinfo ,HttpStatus.ACCEPTED); 	
	}
	

	@DeleteMapping("/staffs/{staffid}")
	public void deleteStaff(@PathVariable int staffid) {
		UniversityStaffMember staff = ustaffService.getStaffById(staffid)
				.orElseThrow(()-> new StaffNotFoundException("Staff not exist with this id:" + staffid)); 
	       ustaffService.removeStaff(staffid);
		   ResponseEntity.ok(staff);

	}
	
	@GetMapping("/staffs")
	public List<UniversityStaffMember> getAllStaffs(){	
    return ustaffService.getAllStaffs();
		
	}
	
	
	
	
	
}
	








//public ResponseEntity<UniversityStaffMember> updateStaff(@RequestBody UniversityStaffMemberDTO staffdto) {
//UniversityStaffMember staff = new UniversityStaffMember();
//staff.setStaffid(staffdto.getStaffid());
//staff.setPassword(staffdto.getPassword());
//staff.setRole(staffdto.getRole());
//UniversityStaffMember updateinfo = ustaffService.updateStaff(staff);
// return new ResponseEntity<>(updateinfo ,HttpStatus.CREATED); 	
//}

//@GetMapping("/staffs/{staffid}")
//public Optional <UniversityStaffMember> viewStaff(@PathVariable("staffid") int staffid) {
//return ustaffService.getStaffById(staffid);   
//}










	

	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	

