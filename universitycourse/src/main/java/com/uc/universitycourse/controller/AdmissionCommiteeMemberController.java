package com.uc.universitycourse.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uc.universitycourse.entities.AdmissionCommiteeMember;
import com.uc.universitycourse.service.AdmissionCommiteeMemberService;



@RestController
public class AdmissionCommiteeMemberController {
	@Autowired
	private AdmissionCommiteeMemberService admincomitte;
	
	@PostMapping("/createMember")
	public AdmissionCommiteeMember createMember(@RequestBody AdmissionCommiteeMember member) {
		return admincomitte.addCommiteeMember(member);
	}
	@PutMapping("/updateMember")
	public AdmissionCommiteeMember updateMember(@RequestBody AdmissionCommiteeMember member) {
		return admincomitte.updateCommiteeMember(member);
	}
	@GetMapping("/getMember/{adminId}")
	public AdmissionCommiteeMember getMember(@PathVariable int adminId) {
		return admincomitte.viewCommiteeMember(adminId);
	}
	@GetMapping("/getallMembers")
	public List<AdmissionCommiteeMember> getAllMember() {
		return admincomitte.viewAllCommiteeMembers();		
	}
}




