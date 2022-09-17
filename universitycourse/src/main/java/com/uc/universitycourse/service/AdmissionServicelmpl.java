package com.uc.universitycourse.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.Admission;
import com.uc.universitycourse.exception.AdmissionNotFoundException;
import com.uc.universitycourse.repository.AdmissionRepository;

@Service
public class AdmissionServicelmpl implements AdmissionService {
	private static final Logger log = LoggerFactory.getLogger(AdmissionServicelmpl.class);
	@Autowired
	private AdmissionRepository admissionRepository ; 
	
	@Override
	public Admission save(Admission admission) {
		log.info("enter in add Admission");
		return admissionRepository.save(admission);
	}
	@Override
	public Admission deleteById(int admissionId) throws AdmissionNotFoundException{
		 Admission admission=admissionRepository.findByAdmissionId(admissionId);
		 if(admission!=null)
		 {
			 admissionRepository.deleteById(admissionId);
			 log.info("given admissionId data delete successfully");
		return admission ;
		 }
		else
		{
			log.error("admissionId is not Correct");
			throw new AdmissionNotFoundException("please enter valid admissionId");
		}	
	}
//	@Override
//	public Admission updateApplicantCourse(int applicantId,int courseId) throws AdmissionNotFoundException {
//		 Admission admission = admissionRepository.findByApplicantId(applicantId);
//		 if(admission!=null)
//		 {
//		 admission.setCourseId(courseId);
//		 admissionRepository.save(admission);
//		return admission;
//		 }
//		 else
//		 {
//			 log.error("ApplicantId is not Correct");
//			 throw new AdmissionNotFoundException("please enter valid ApplicantId");
//	}
//	}
	@Override
	
	public List<Admission> showAllAdmissionByCourse(String course) 
	{
		 List<Admission> admission = admissionRepository.findAllByCourse(course);
		 log.info("this is ouput of showAll Admission By CourseId");
			return admission;
		
	}
	public AdmissionServicelmpl(AdmissionRepository admissionRepository) {
		super();
		this.admissionRepository = admissionRepository;
	}
	public AdmissionServicelmpl() {
		super();
		}
	

}
