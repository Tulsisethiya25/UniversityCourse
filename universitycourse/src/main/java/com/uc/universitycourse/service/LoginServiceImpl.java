package com.uc.universitycourse.service;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.AdmissionCommiteeMember;
import com.uc.universitycourse.entities.Applicant;
import com.uc.universitycourse.entities.UniversityStaffMember;
import com.uc.universitycourse.exception.StaffNotFoundException;
import com.uc.universitycourse.repository.AdmissionCommiteeMemberRepository;
import com.uc.universitycourse.repository.ApplicantRepository;
import com.uc.universitycourse.repository.UniversityStaffRepository;

@Service
public class LoginServiceImpl implements ILoginService{
	@Autowired
	private ApplicantRepository applicantrepo;
	@Autowired
	private AdmissionCommiteeMemberRepository adminrepo;
	@Autowired
	private UniversityStaffRepository staffrepo;
	
	@Override
	public String loginAsUniversityStaffMember(int staffid, String pwd) {
		UniversityStaffMember unis =staffrepo.getById(staffid);
		if(unis!=null && unis.getPassword().equals(pwd)) {
				return "staff successfully Login";
			}
		
		return "Login Failed";
		
	}
	@Override
	public String loginAsApplicant(int applicantId, String pwd) {
		Applicant applicant =applicantrepo.findByApplicantId(applicantId);
		if(applicant!=null && applicant.getPassword().equals(pwd)) {
				return "Applicant successfully Login";
			}
		else
		return "Login Failed";
		
	}
	@Override
	public String loginAsAdmissionComiteeMember(int adminId, String pwd) {
		AdmissionCommiteeMember admin =adminrepo.findAdmissionComitteeMemberByadminId(adminId);
		if(admin!=null && admin.getPassword().equals(pwd)) {
				return "successfully Login";
			}
		else
		return "Login Failed";
		
	}
//	@Override
//	public String loginAsAdmin(int staffId, String pwd) {
//		 unis =staffrepo.findBystaffid(staffId);
//		if(unis!=null && unis.getPassword().equals(pwd)) {
//				return "staff successfully Login";
//			}
//		
//		return "Login Failed";
//		
//	}

}
