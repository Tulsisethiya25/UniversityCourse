package com.uc.universitycourse.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uc.universitycourse.dto.ApplicantDto;
import com.uc.universitycourse.entities.Applicant;
import com.uc.universitycourse.exception.ApplicantNotFoundException;
import com.uc.universitycourse.service.ApplicantService;

@RestController
public class ApplicantController {
	@Autowired
	ApplicantService applicantService;
	@PostMapping("/addApplicant")
    public Applicant addApplicant(@RequestBody ApplicantDto applicantdto) 
    {
		Applicant applicant=new Applicant();
		applicant.setAdmission(applicantdto.getAdmission());
		applicant.setContactNumber(applicantdto.getContactNumber());
		applicant.setStudentDegree(applicantdto.getStudentDegree());
		applicant.setStudentGraduationPercent(applicantdto.getStudentGraduationPercent());
		applicant.setStudentname(applicantdto.getStudentname());
		applicant.setPassword(applicantdto.getPassword());
		 return applicantService.addApplicant(applicant);
		    
       
    }
	@DeleteMapping("/deleteApplicant/{applicantId}")
    public ResponseEntity<Applicant> deleteApplicantByApplicantId(@PathVariable int applicantId) throws ApplicantNotFoundException
    {
		Applicant applicantdeleteInfo = applicantService.deleteApplicantByApplicantId(applicantId);
		  
        return new ResponseEntity<>(applicantdeleteInfo ,HttpStatus.OK);
       
    }
	
	  @GetMapping("/viewApplicantByApplicantId/{applicantId}")
	    public Applicant findAllByCourseId(@PathVariable int applicantId) throws ApplicantNotFoundException 
	      {
	    		
		    return applicantService.viewApplicantByApplicantId(applicantId); 
	    }

}
