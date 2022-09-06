package com.uc.universitycourse.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.AdmissionCommiteeMember;
import com.uc.universitycourse.repository.AdmissionCommiteeMemberRepository;



@Service
public class AdmissionCommiteeMemberServiceImpl implements AdmissionCommiteeMemberService{
	private static final Logger log = LoggerFactory.getLogger(AdmissionCommiteeMemberServiceImpl.class);
	@Autowired
	public AdmissionCommiteeMemberRepository adminrepo;
	@Override
	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member) {
		
		log.info("CommiteeMember added successfully");
		return adminrepo.save(member);
	}

	@Override
	public AdmissionCommiteeMember updateCommiteeMember( AdmissionCommiteeMember member) {
		AdmissionCommiteeMember adminMem=adminrepo.findAdmissionComitteeMemberByadminId(member.getAdminId());
		adminMem.setAdminName(member.getAdminName());
		adminMem.setAdminContact(member.getAdminContact());
		log.info("updated CommiteeMember");
		return adminrepo.save(adminMem);
	}

	@Override
	public AdmissionCommiteeMember viewCommiteeMember(int adminId) {
		log.info("this is ouput of viewCommiteeMember");
		return adminrepo.findAdmissionComitteeMemberByadminId(adminId);
	}

	@Override
	public void removeCommiteeMember(int adminId) {
		log.info("deleted CommiteeMember");
		adminrepo.deleteById(adminId);
		
	}

	@Override
	public List<AdmissionCommiteeMember> viewAllCommiteeMembers() {
		
		log.info("this is ouput of viewAllCommiteeMembers");
		return adminrepo.findAll();
	}

	

}
