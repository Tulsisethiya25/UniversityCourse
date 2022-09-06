package com.uc.universitycourse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uc.universitycourse.entities.UniversityStaffMember;
import com.uc.universitycourse.repository.UniversityStaffRepository;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

class StaffTest {
	
    @Autowired
    UniversityStaffRepository staffrepo;
	
	
	@Test
	@Order(1)
	void testCreate() {
		UniversityStaffMember staff = new UniversityStaffMember();
		staff.setStaffid(20);
		staff.setPassword("abccdf123");
		staff.setRole("professor");
		staffrepo.save(staff);
		assertNotNull(staffrepo.findById(20).get());
			
	}
	@Test
	@Order(2)
	void testReadAll() {
		List<UniversityStaffMember>list=(List<UniversityStaffMember>) staffrepo.findAll();
		assertThat(list).size().isPositive();
	}
    @Test
    @Order(3)
	void testRead() {
		UniversityStaffMember mem = staffrepo.findById(20).get();
		assertEquals("professor", mem.getRole());
	}
	
    @Test
    @Order(4)
    void testUpdate() {
    	UniversityStaffMember staff = staffrepo.findById(20).get();
    	staff.setPassword("aqaqa");
    	staffrepo.save(staff);
    	assertNotEquals("123abc",staffrepo.findById(20).get().getPassword());		
    }
    
    @Test
    @Order(5)
    void testDelete() {
    	staffrepo.deleteById(20);
    	assertThat(staffrepo.existsById(20)).isFalse();
    }

}
