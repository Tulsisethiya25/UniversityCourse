package com.uc.universitycourse.service;



import java.util.List;


import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.AdmissionStatus;
import com.uc.universitycourse.entities.Applicant;
import com.uc.universitycourse.exception.ApplicantNotFoundException;


@Service
public interface ApplicantService { 
	public Applicant addApplicant(Applicant applicant );
	public Applicant deleteApplicantByApplicantId(int applicantId) throws ApplicantNotFoundException;
	public Applicant viewApplicantByApplicantId(int applicantId) throws ApplicantNotFoundException;
	public List<Applicant> getAllApplicants();

	public List<Applicant> viewApplicantByStatus(AdmissionStatus status);
	public String updateApplicantStatus(int applicantId , AdmissionStatus status);
}
