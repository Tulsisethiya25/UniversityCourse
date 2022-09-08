package com.uc.universitycourse.service;





import java.util.List;

import com.uc.universitycourse.entities.Admission;
import com.uc.universitycourse.exception.AdmissionNotFoundException;


public interface AdmissionService {
	public Admission save(Admission admission);
	public Admission deleteById(int admissionId) throws AdmissionNotFoundException;
	public Admission updateApplicantCourse(int applicantId,int courseId) throws AdmissionNotFoundException;
	public List<Admission> showAllAdmissionByCourseId(int courseId);
	
}
