package com.uc.universitycourse.entities;

public enum AdmissionStatus {
	APPLIED("Applied"),
	PENDING("pending"),
	CONFIRMED("confirmed"),
	REJECTED("rejected");
	
	String value;
	
	AdmissionStatus(String value){
		this.value=value;
	}

}
