package com.uc.universitycourse.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.uc.universitycourse.entities.UniversityStaffMember;


@Repository
	public interface UniversityStaffRepository extends JpaRepository<UniversityStaffMember,Integer>{
       


}
