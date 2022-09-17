package com.uc.universitycourse.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.uc.universitycourse.entities.Admission;
import com.uc.universitycourse.entities.AdmissionStatus;

public class ApplicantDto {
	private int applicantId;
	private String studentname;
    private String contactNumber;
    private String studentDegree;
    private int studentGraduationPercent;
//	private int CourseId;
    private AdmissionStatus status;
    private Admission admission;
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private int admissionId;

//    public int getCourseId() {
//		return CourseId;
//	}
//	public void setCourseId(int courseId) {
//		CourseId = courseId;
//	}
	public AdmissionStatus getStatus() {
		return status;
	}
	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}
//	public int getAdmissionId() {
//		return admissionId;
//	}
//	public void setAdmissionId(int admissionId) {
//		this.admissionId = admissionId;
//	}

//    private Admission admission;


    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getStudentDegree() {
		return studentDegree;
	}
	public void setStudentDegree(String studentDegree) {
		this.studentDegree = studentDegree;
	}
	public int getStudentGraduationPercent() {
		return studentGraduationPercent;
	}
	public void setStudentGraduationPercent(int studentGraduationPercent) {
		this.studentGraduationPercent = studentGraduationPercent;
	}
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	}
