package com.uc.universitycourse.exception;

public class CourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9119154883314180547L;

	public CourseNotFoundException(String message) {
		super(message);
	}

}
