package com.uc.universitycourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.uc.universitycourse.entities.AdmissionCommiteeMember;



@Repository
public interface AdmissionCommiteeMemberRepository extends JpaRepository<AdmissionCommiteeMember,Integer>{
	public AdmissionCommiteeMember findAdmissionComitteeMemberByadminId(int adminId);
	public int deleteByadminName(String adminName);
	public boolean existsAdmissionComitteeMemberByadminId(int adminId);
}