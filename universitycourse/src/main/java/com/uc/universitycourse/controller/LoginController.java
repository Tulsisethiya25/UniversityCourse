package com.uc.universitycourse.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.uc.universitycourse.entities.LoginDetails;
import com.uc.universitycourse.service.ILoginService;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	private ILoginService login;
	@PostMapping("/loginStaff")
	public String loginStaff(@RequestBody LoginDetails logdetails ) {
		return login.loginAsUniversityStaffMember(logdetails.getLoginId(), logdetails.getPassword());		
		}
//	@PostMapping("/loginAdmin")
//	public String loginAdmin(@RequestBody LoginDetails logdetails ) {
//		return login.loginAsAdmin(logdetails.getLoginId(), logdetails.getPassword());		
//		}
	@PostMapping("/loginCommitee")
	public String loginCommiteeMember(@RequestBody LoginDetails logdetails ) {
		return login.loginAsAdmissionComiteeMember(logdetails.getLoginId(), logdetails.getPassword());		
		}
	@PostMapping("/loginApplicant")
	public String loginApplicant(@RequestBody LoginDetails logdetails ) {
		return login.loginAsApplicant(logdetails.getLoginId(), logdetails.getPassword());		
		}


}
