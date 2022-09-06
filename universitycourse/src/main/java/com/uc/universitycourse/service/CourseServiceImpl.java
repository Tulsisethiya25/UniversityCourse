package com.uc.universitycourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uc.universitycourse.entities.Course;
import com.uc.universitycourse.exception.CourseNotFoundException;
import com.uc.universitycourse.exception.NoDataFoundException;
import com.uc.universitycourse.repository.ICourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CourseServiceImpl implements ICourseService {
	private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);
	@Autowired
	 
	private ICourseRepository icourseRepository;
	@Override
	public Course save(Course course) {
		
		log.info("Course added successfully");
		return icourseRepository.save(course);
	}

	@Override
	public Course deleteById(int courseId) {
		Course course =  icourseRepository.findByCourseId(courseId);
		if(course!=null)
		 {
		
		icourseRepository.deleteById(courseId);
		 log.info("given courseID deleted successfully");
		return course ;
		 }else
			{
				log.error("courseId is not Correct");
				throw new NoDataFoundException("please enter valid courseId");
			}
	}
	
	
	@Override
	public Course updateCourses(String courseName,int courseId) {
		Course course = icourseRepository.findByCourseId(courseId);
		if(course!=null)
		 {
		course.setCourseName(courseName);
		
		icourseRepository.save(course);
		return course;
		 }   else
		 {
			 log.error("CourseId is not Correct");
			 throw new NoDataFoundException("please enter valid couseId");
	}
		
	}
    @Override
	
	public List<Course> showAllCousesByCourseId(int courseId)
	{
		 List<Course> course = icourseRepository.findAllByCourseId(courseId);
			
			
			if (!course.isEmpty()) {
				return course;
			}
			throw new CourseNotFoundException("Course not found for the id->"+courseId);
		
	}

	@Override
	public List<Course> findAll() {
		
		List<Course> course = icourseRepository.findAll();
	
		if (!course.isEmpty()) {
			return course;
		}
		throw new NoDataFoundException("No Courses available");
	
	}
    
	

	
	

	
}
