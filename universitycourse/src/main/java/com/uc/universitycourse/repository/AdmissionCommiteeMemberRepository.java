package com.uc.universitycourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.uc.universitycourse.entities.AdmissionCommiteeMember;


@Repository
public interface AdmissionCommiteeMemberRepository extends JpaRepository<AdmissionCommiteeMember,Integer>{
	public AdmissionCommiteeMember findAdmissionComitteeMemberByadminName(String adminName);
	public int deleteByadminName(String adminName);
	public boolean existsAdmissionComitteeMemberByadminName(String adminName);
	AdmissionCommiteeMember findAdmissionComitteeMemberByadminId(int adminId);
}