package com.uc.universitycourse.service;

import java.util.List;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.AdmissionStatus;
import com.uc.universitycourse.entities.Applicant;
import com.uc.universitycourse.exception.ApplicantNotFoundException;
import com.uc.universitycourse.repository.ApplicantRepository;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	private static final Logger log = LoggerFactory.getLogger(ApplicantServiceImpl.class);
	
	@Autowired
	private ApplicantRepository applicantRepo; 
	
	@Override
	public Applicant addApplicant(Applicant applicant) {
		log.info("enter ApplicantServiceImpl :: addAplicant()");
		if(applicantRepo.existsApplicantBycontactNumber(applicant.getContactNumber())) {
			throw new ApplicantNotFoundException("applicant already exist");
			
		}
		return applicantRepo.save(applicant);
	}

	@Override
	public List<Applicant> getAllApplicants() {
		log.info("enter ApplicantServiceImpl :: getAllAplicants()");
		
		return applicantRepo.findAll();
	}

	@Override
	public Applicant deleteApplicantByApplicantId(int applicantId) throws ApplicantNotFoundException {
		 Applicant applicant=applicantRepo.findByApplicantId(applicantId);
		 if(applicant!=null)
		 {
			 applicantRepo.deleteById(applicantId);
		return applicant ;
		 }
		else
			throw new ApplicantNotFoundException("please enter valid applicantId");
	}

	@Override
	public Applicant viewApplicantByApplicantId(int applicantId) throws ApplicantNotFoundException {
		Applicant applicant=applicantRepo.findByApplicantId(applicantId);
		 if(applicant!=null)
		 {
		return applicant ;
		 }
		else
			throw new ApplicantNotFoundException("please enter valid applicantId");
	}

	@Override
	public List<Applicant> viewApplicantByStatus(AdmissionStatus status) throws ApplicantNotFoundException {
		return applicantRepo.findAllByStatus(status);
	}
	
	@Override
	public String updateApplicantStatus(int applicantId ,AdmissionStatus status) {
    Applicant applicant=applicantRepo.findByApplicantId(applicantId);
    applicant.setStatus(status);
    applicantRepo.save(applicant);
    return "Status Update Successfully";

	}
	

	public ApplicantServiceImpl() {
		super();
		}


	public ApplicantServiceImpl(ApplicantRepository applicantRepo) {
		super();
		this.applicantRepo = applicantRepo;
	}
	

}
