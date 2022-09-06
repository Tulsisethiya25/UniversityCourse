package com.uc.universitycourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uc.universitycourse.entities.Course;
import com.uc.universitycourse.exception.CourseNotFoundException;
import com.uc.universitycourse.service.ICourseService;

@RestController
public class UniversityCourse {
	
	@Autowired

    private ICourseService icourseService;
	@PostMapping("/addCourse")
    public Course save(@RequestBody Course course) 
    {

	   return icourseService.save(course);
		    
       
    }
	@DeleteMapping("/deleteCourse")
    public Course deleteCourse(@RequestBody int courseId) throws CourseNotFoundException 
    {
		return icourseService.deleteById(courseId);    
    }
	
	@PutMapping("/updateCourse/{courseName}/{courseId}")
    public Course updateCourse(@PathVariable String courseName,@PathVariable int courseId ) throws CourseNotFoundException 
    {
		return icourseService.updateCourses(courseName,courseId);
		   
       
    }

    @GetMapping("/viewCourse/{courseId}")
    public List<Course> findByCourseId(@PathVariable int courseId) throws CourseNotFoundException 
      {
    		
	    return icourseService.showAllCousesByCourseId(courseId);
		   
        
    }
    @GetMapping("/viewAllCourses")
    public List<Course> viewAllCourses() 
      {
    		
	    return icourseService.findAll();
		   
      }

}
