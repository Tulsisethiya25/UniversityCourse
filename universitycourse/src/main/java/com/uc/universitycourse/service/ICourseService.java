package com.uc.universitycourse.service;

import java.util.List;

import com.uc.universitycourse.entities.Course;
import com.uc.universitycourse.exception.CourseNotFoundException;

public interface ICourseService {
	public Course save(Course course);
	public Course deleteById(int courseId) throws CourseNotFoundException;
	public Course updateCourses(int courseId, Course course) throws CourseNotFoundException;
	public List<Course> showAllCousesByCourseId(int courseId) throws CourseNotFoundException;
	public List<Course> findAll();
	Course findByCourseId (int courseId);
	
	
}
