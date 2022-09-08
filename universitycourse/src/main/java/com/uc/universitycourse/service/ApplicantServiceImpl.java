package com.uc.universitycourse.service;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	public ApplicantServiceImpl() {
		super();
		}


	public ApplicantServiceImpl(ApplicantRepository applicantRepo) {
		super();
		this.applicantRepo = applicantRepo;
	}
	

}
