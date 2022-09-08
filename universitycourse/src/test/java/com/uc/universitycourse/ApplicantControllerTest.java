package com.uc.universitycourse;

import static org.junit.jupiter.api.Assertions.*;



import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.uc.universitycourse.entities.Applicant;
import com.uc.universitycourse.repository.ApplicantRepository;
import com.uc.universitycourse.service.ApplicantService;
import com.uc.universitycourse.service.ApplicantServiceImpl;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApplicantControllerTest {

	@Mock
	private ApplicantRepository applicantRepo;
	@InjectMocks
	private ApplicantService applicantService=new ApplicantServiceImpl();

	@BeforeEach 
	void setUp() {
		this.applicantService=new ApplicantServiceImpl(this.applicantRepo);
		Applicant applicant=new Applicant();
		
		applicant.setContactNumber("9425987651");
		applicant.setApplicantId(1);
		applicant.setStudentDegree("MCA");
		applicant.setStudentGraduationPercent(92);
		applicant.setStudentname("Tulsi");
		applicantService.addApplicant(applicant);
		
		}
	@Test
	void testAddApplicantAdmission() {
		Applicant applicant=new Applicant();
		applicant.setContactNumber("9425987651");
		applicant.setStudentDegree("MCA");
		applicant.setStudentGraduationPercent(92);
		applicant.setStudentname("Tulsi");
		applicantService.addApplicant(applicant);
		verify(applicantRepo).save(applicant);
	}
	
	

	
	


}
