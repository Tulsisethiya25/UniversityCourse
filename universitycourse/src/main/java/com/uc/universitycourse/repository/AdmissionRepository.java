package com.uc.universitycourse.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uc.universitycourse.entities.Admission;

@Repository
public interface AdmissionRepository extends CrudRepository<Admission, Integer> {
	List<Admission> findAllByCourseId(int courseId);
	List<Admission> findAllByAdmissionDate(LocalDate admissionDate);
	 Admission findByApplicantId (int applicantId);
	 Admission findByAdmissionId (int admissionId);
}
