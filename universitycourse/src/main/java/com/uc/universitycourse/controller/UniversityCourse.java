package com.uc.universitycourse.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.uc.universitycourse.dto.CourseDto;
import com.uc.universitycourse.entities.Course;
import com.uc.universitycourse.exception.CourseNotFoundException;
import com.uc.universitycourse.repository.ICourseRepository;
import com.uc.universitycourse.service.ICourseService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UniversityCourse {
	
	@Autowired

    private ICourseService icourseService;
	private ICourseRepository iCourseRepository;
	@PostMapping("/courses")
    public ResponseEntity<Course> save( @Valid @RequestBody CourseDto courseDto) 
    {
		Course course=new Course();	
		course.setCourseId(courseDto.getCourseId());
		course.setCourseDuration(courseDto.getCourseDuration());
		course.setCourseName(courseDto.getCourseName());
		course.setCourseFees(courseDto.getCourseFees());
		Course courseInfo = icourseService.save(course);
		return new ResponseEntity<>(courseInfo ,HttpStatus.CREATED);    
    }
	@DeleteMapping("/courses/{courseId}")
    public ResponseEntity<Course> deleteCourse(@PathVariable int courseId) throws CourseNotFoundException 
    {		
		Course courseInfo = icourseService.deleteById(courseId);	  
        return new ResponseEntity<>(courseInfo ,HttpStatus.CREATED);
	     
    }
	
	@PutMapping("/courses/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer courseId ,@RequestBody CourseDto courseDto  ) throws CourseNotFoundException 
    {
		
		
		Course courseData = icourseService.findByCourseId(courseId);
		Course course=new Course();	
		course.setCourseId(courseData.getCourseId());
		course.setCourseName(courseDto.getCourseName());
		course.setCourseDuration(courseDto.getCourseDuration());
		course.setCourseFees(courseDto.getCourseFees());
		Course courseInfo = icourseService.save(course);		   
        return new ResponseEntity<>(courseInfo,HttpStatus.ACCEPTED);	
        
        
        
       
    }
	
	
    @GetMapping("/courses/{courseId}")
    public List<Course> findByCourseId(@PathVariable int courseId) throws CourseNotFoundException 
      {
    		
	    return icourseService.showAllCousesByCourseId(courseId);
		   
        
    }
    @GetMapping("/courses")
    public List<Course> viewAllCourses() 
      {
    		
	    return icourseService.findAll();
		   
      }

}
