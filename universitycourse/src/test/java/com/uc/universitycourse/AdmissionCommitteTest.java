package com.uc.universitycourse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uc.universitycourse.entities.AdmissionCommiteeMember;
import com.uc.universitycourse.repository.AdmissionCommiteeMemberRepository;


@SpringBootTest

 class AdmissionCommitteTest {
	@Autowired
	AdmissionCommiteeMemberRepository adminrepo;


	@Test
	void testCreate() {
		AdmissionCommiteeMember a = new AdmissionCommiteeMember();
		a.setAdminId(1);
		a.setAdminName("java");
		a.setAdminContact("12345");
		a.setPassword("racingcar26");
		adminrepo.save(a);
		assertNotNull(adminrepo.findById(1).get());
		
		
}
	@Test
	void testReadAll() { 
		List<AdmissionCommiteeMember> list = (List<AdmissionCommiteeMember>) adminrepo.findAll();
		assertThat(list).size().isPositive();
		
	}
	
	@Test
     void testSingleProduct () {
		AdmissionCommiteeMember admissioncommiteemember = adminrepo.findById(1).get();
		assertEquals("java", admissioncommiteemember.getAdminName());
		
	}
	
	@Test
	 void testUpdate() {
		AdmissionCommiteeMember a = adminrepo.findById(1).get();
		a.setAdminContact("12355");
		adminrepo.save(a);
		assertNotEquals("12345",adminrepo.findById(1).get().getAdminContact());
	}
	
	@Test
	 void testDelete() {
		adminrepo.deleteById(1);
		assertThat(adminrepo.existsById(1)).isFalse();
		
		
	}

}
