package com.uc.universitycourse.repository;


import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;

import com.uc.universitycourse.entities.UniversityStaffMember;



@Repository
public interface UniversityStaffRepository extends CrudRepository<UniversityStaffMember,Integer> {
	public UniversityStaffMember findUniversityStaffMemberBystaffid(int staffId);

	        

}
