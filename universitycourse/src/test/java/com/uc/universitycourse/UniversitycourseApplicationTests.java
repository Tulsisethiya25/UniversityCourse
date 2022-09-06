package com.uc.universitycourse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uc.universitycourse.entities.Course;
import com.uc.universitycourse.repository.ICourseRepository;

@SpringBootTest
class UniversitycourseApplicationTests {

	@Autowired
	ICourseRepository icourseRepo;
	
	@Test
    void testCreate() {
		Course c = new Course();
		c.setCourseId(1);
		c.setCourseName("react");
		c.setCourseDuration("2years");
		c.setCourseFees("5000");
		icourseRepo.save(c);
		assertNotNull(icourseRepo.findById(1).get());
		
	}
	
	@Test
	void testSingleCourse() {
		Course course = icourseRepo.findById(1).get();
		assertEquals("react", course.getCourseName());
	}
	
	@Test
	 void testupdate() {
		Course c =icourseRepo.findById(1).get();
		c.setCourseFees("2000");
		icourseRepo.save(c);
		assertNotEquals("5000",icourseRepo.findById(1).get().getCourseFees());
		
	}
	 
	@Test
	void testDelete() {
		icourseRepo.deleteById(1);
		assertThat(icourseRepo.existsById(1)).isFalse();
		
	}

	
	
}
