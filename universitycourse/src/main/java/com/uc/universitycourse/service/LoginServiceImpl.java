package com.uc.universitycourse.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.AdmissionCommiteeMember;
import com.uc.universitycourse.entities.UniversityStaffMember;
import com.uc.universitycourse.repository.AdmissionCommiteeMemberRepository;
import com.uc.universitycourse.repository.ApplicantRepository;
import com.uc.universitycourse.repository.UniversityStaffRepository;

@Service
public class LoginServiceImpl implements ILoginService{
	@Autowired
	private ApplicantRepository apprepo;
	@Autowired
	private AdmissionCommiteeMemberRepository adminrepo;
	@Autowired
	private UniversityStaffRepository unistaff;
	@Override
	public boolean loginAsApplicant(int applicantId, String pwd) {
		if(apprepo.existsApplicantByApplicantId(applicantId)&& apprepo.existsApplicantBypassword(pwd)) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean loginAsAdmissionComiteeMember(int adminId, String pwd) {
		
		if(adminrepo.existsAdmissionComitteeMemberByadminId(adminId) ) {
			
			AdmissionCommiteeMember adminmem=adminrepo.findAdmissionComitteeMemberByadminId(adminId);
		
			if((adminmem.getPassword()).equals(pwd)) {
				return true;
			}
		}
		return false;
				}

	@Override
	public boolean loginAsUniversityStaffMember(int userId, String pwd) {
		UniversityStaffMember unis =unistaff.findUniversityStaffMemberBystaffid(userId);
		if(unis!=null && unis.getPassword().equals(pwd)) {
				return true;
			}
		
		return false;
		
	}

}
