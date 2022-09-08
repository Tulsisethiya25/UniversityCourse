package com.uc.universitycourse.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.uc.universitycourse.entities.Applicant;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Integer> {
    Applicant findByApplicantId(int applicantId);
    void deleteByApplicantId(int applicantId);
    public boolean existsApplicantByApplicantId(int applicantId);
	public boolean existsApplicantBypassword(String pwd);
	public boolean existsApplicantBycontactNumber(String contactNumber);

}
