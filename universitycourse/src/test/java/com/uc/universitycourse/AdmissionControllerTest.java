package com.uc.universitycourse;

import static org.mockito.Mockito.verify;






import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.uc.universitycourse.entities.Admission;
import com.uc.universitycourse.repository.AdmissionRepository;
import com.uc.universitycourse.service.AdmissionService;
import com.uc.universitycourse.service.AdmissionServicelmpl;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AdmissionControllerTest {
	@Mock
	private AdmissionRepository admissionRepo;
	@InjectMocks
	private AdmissionService admissionService=new AdmissionServicelmpl();

	@BeforeEach
	void setUp() {
		this.admissionService=new AdmissionServicelmpl(this.admissionRepo);
		Admission admission=new Admission();
		admission.setAdmissionId(0);
//		admission.setApplicantId(1);
		admission.setCourse("Java");
	    admissionService.save(admission);
	}
	@Test
	void testAddApplicantAdmission() {
		Admission admission=new Admission();
		admission.setAdmissionId(0);
//		admission.setApplicantId(1);
		admission.setCourse("Java");
	    admissionService.save(admission);
		verify(admissionRepo).save(admission);
	}
	
	@Test
	void testShowAllAdmissionByCourseId() {
		admissionService.showAllAdmissionByCourse("123");
	    	verify(admissionRepo).findAllByCourse("123");
	}
	
	
	
}
