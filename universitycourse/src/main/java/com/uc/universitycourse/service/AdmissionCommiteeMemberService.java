package com.uc.universitycourse.service;

import java.util.List;

import com.uc.universitycourse.entities.AdmissionCommiteeMember;


public interface AdmissionCommiteeMemberService {
	public  AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member);
	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member);
	public AdmissionCommiteeMember viewCommiteeMember(int adminId);
	public void removeCommiteeMember(int adminId);
	public List<AdmissionCommiteeMember> viewAllCommiteeMembers();

}
