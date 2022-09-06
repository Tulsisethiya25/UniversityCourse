package com.uc.universitycourse.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uc.universitycourse.entities.LoginDetails;
import com.uc.universitycourse.repository.ILoginRepository;
import com.uc.universitycourse.service.LoginServiceImpl;


@RestController
public class LoginController {
	@Autowired
	private LoginServiceImpl login;
	@Autowired
	private ILoginRepository logrepo;
	@GetMapping("/loginApplicant")
	public String loginApplicant(@RequestBody LoginDetails logdetails ) {
		if(login.loginAsApplicant(logdetails.getLoginId(), logdetails.getPassword())) {
			logrepo.save(logdetails);
			
			return "Login Success";
		}
		else {
			return "Login Failed";
		}
	}
	@GetMapping("/loginComitteeMember")
	public String loginComittee(@RequestBody LoginDetails logdetails) {
		if(login.loginAsAdmissionComiteeMember( logdetails.getLoginId(), logdetails.getPassword())) {
			logrepo.save(logdetails);
			return "Login Successful";
		}
		else {
			return "Login Failed";
		}
	}
	@GetMapping("/loginUniversityStaff")
	public String loginStaff(@RequestBody LoginDetails logdetails) {
		if(login.loginAsUniversityStaffMember(logdetails.getLoginId(),logdetails.getPassword())) {
			
			logrepo.save(logdetails);
			return "Login Staffmember successfull!!";
			
		}
		else {
			return "login Failed";
		}
	}

}
