package com.uc.universitycourse.service;

import com.uc.universitycourse.exception.LoginFailedException;

public interface ILoginService {
	public boolean loginAsApplicant(int applicantId,String pwd) throws LoginFailedException;
	public boolean loginAsAdmissionComiteeMember(int adminId,String pwd) throws LoginFailedException;
	public boolean loginAsUniversityStaffMember(int userId,String pwd);

}
