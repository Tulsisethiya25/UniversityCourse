package com.uc.universitycourse.service;



import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.Applicant;
import com.uc.universitycourse.exception.ApplicantNotFoundException;


@Service
public interface ApplicantService {
	public Applicant addApplicant(Applicant applicant );
	public Applicant deleteApplicantByApplicantId(int applicantId) throws ApplicantNotFoundException;
	public Applicant viewApplicantByApplicantId(int applicantId) throws ApplicantNotFoundException;

	

}
