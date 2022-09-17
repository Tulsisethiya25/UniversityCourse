package com.uc.universitycourse.service;

import com.uc.universitycourse.exception.LoginFailedException;

public interface ILoginService {
//	public String loginAsAdmin(int adminId,String pwd) throws LoginFailedException;
	public String loginAsApplicant(int applicantId,String pwd) throws LoginFailedException;
	public String loginAsAdmissionComiteeMember(int adminId,String pwd) throws LoginFailedException;
	public String loginAsUniversityStaffMember(int userId,String pwd);

}
