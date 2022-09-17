package com.uc.universitycourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.uc.universitycourse.entities.LoginDetails;


@Repository
public interface ILoginRepository extends JpaRepository<LoginDetails,Integer>{
	public Boolean existsLoginDetailsByLoginId(int loginId);
	
}
