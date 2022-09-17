package com.uc.universitycourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uc.universitycourse.dto.ApplicantDto;
import com.uc.universitycourse.entities.AdmissionStatus;
import com.uc.universitycourse.entities.Applicant;
import com.uc.universitycourse.exception.ApplicantNotFoundException;
import com.uc.universitycourse.service.ApplicantService;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class ApplicantController {
	@Autowired
	ApplicantService applicantService;
	@GetMapping("/applicants")
	public List<Applicant> getAllApplicants(){
		return applicantService.getAllApplicants();
	}
	@PostMapping("/addApplicant")
    public Applicant addApplicant(@RequestBody ApplicantDto applicantdto) 
    {
		Applicant applicant=new Applicant();
		applicant.setAdmission(applicantdto.getAdmission());
//		applicant.setAdmissionId(applicantdto.getAdmissionId());
//		applicant.setCourseId(applicantdto.getCourseId());
		applicant.setStatus(applicantdto.getStatus());
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
	    public Applicant findAllByApplicantId(@PathVariable int applicantId) throws ApplicantNotFoundException 
	      {
	    		
		    return applicantService.viewApplicantByApplicantId(applicantId); 
	    }
	  @GetMapping("/viewApplicantByStatus/{status}")
	    public List<Applicant> findAllByStatus(@PathVariable AdmissionStatus status) throws ApplicantNotFoundException 
	      {
	    		
		    return applicantService.viewApplicantByStatus(status); 
	    }

	  @PutMapping("/updateApplicantStatus/{applicantId}/{status}")
	    public String updateApplicantByStatus(@PathVariable int applicantId ,@PathVariable AdmissionStatus status)
	      {
	    		
		    return applicantService.updateApplicantStatus(applicantId ,status); 
	    }

}
