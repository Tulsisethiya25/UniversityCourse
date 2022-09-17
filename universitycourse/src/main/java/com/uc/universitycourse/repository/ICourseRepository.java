package com.uc.universitycourse.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uc.universitycourse.entities.Course;
@Repository
public interface ICourseRepository extends CrudRepository<Course,Integer>  {

	Course save(Course course);
	List<Course> findAllByCourseId(int courseId);
	Course findByCourseId (int courseId);
	List<Course> findAll();
	

	
	

}
