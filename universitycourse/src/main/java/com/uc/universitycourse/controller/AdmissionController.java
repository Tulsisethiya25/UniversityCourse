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
import org.springframework.web.bind.annotation.RestController;

import com.uc.universitycourse.dto.AdmissionDto;
import com.uc.universitycourse.entities.Admission;
import com.uc.universitycourse.exception.AdmissionNotFoundException;
import com.uc.universitycourse.service.AdmissionService;


@RestController
public class AdmissionController {

	@Autowired
    private AdmissionService admissionService;
	
	@PostMapping("/addApplicantAdmission") // Annotation for mapping HTTP POST requests onto specific handler methods.
    public ResponseEntity<Admission> addApplicantAdmission(@Valid @RequestBody AdmissionDto admissiondto) 
    {
		Admission admission=new Admission();
//		admission.setApplicantId(admissiondto.getApplicantId());
		admission.setCourse(admissiondto.getCourse());
//		admission.setStatus(admissiondto.getStatus());
		
		Admission applicantaddinfo = admissionService.save(admission);
		    
        return new ResponseEntity<>(applicantaddinfo ,HttpStatus.CREATED);
       
    }
	@DeleteMapping("/deleteApplicantAdmission")// Annotation for mapping HTTP DELETE requests onto specific handler methods.
    public ResponseEntity<Admission> deleteApplicantAdmission(@RequestBody int admissionId) throws AdmissionNotFoundException 
    {
		Admission applicantdeleteinfo= admissionService.deleteById(admissionId);
		  
        return new ResponseEntity<>(applicantdeleteinfo ,HttpStatus.CREATED);
       
    }

//	@PutMapping("/UpdateApplicantAdmission/{applicantId}/{courseId}")// Annotation for mapping HTTP PUT  requests onto specific handler methods.
//    public ResponseEntity<Admission> updateApplicantAdmission(@PathVariable int applicantId ,@PathVariable int courseId )throws AdmissionNotFoundException
//    {
//		Admission applicant = admissionService.updateApplicantCourse(applicantId,courseId);
//		   
//        return new ResponseEntity<>(applicant,HttpStatus.ACCEPTED);
//       
//    }

	
    @GetMapping("/showAllAdmissionByCourse/{course}")// Annotation for mapping HTTP GET requests onto specific handler methods.
    public List<Admission> findAllByCourseId(@PathVariable String course) 
    {
    		
	    return admissionService.showAllAdmissionByCourse(course);
		   
       
    }

    
}
