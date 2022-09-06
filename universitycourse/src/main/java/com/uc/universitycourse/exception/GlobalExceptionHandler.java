package com.uc.universitycourse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleResourceNotFoundException (CourseNotFoundException ex) {
		ErrorObject eObject = new ErrorObject();
		eObject.setStatus(HttpStatus.NOT_FOUND.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(eObject, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleNoDataFoundException (NoDataFoundException ex) {
		ErrorObject eObject = new ErrorObject();
		eObject.setStatus(HttpStatus.NO_CONTENT.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(eObject, HttpStatus.OK);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleAdmissionNotFoundException (AdmissionNotFoundException ex) {
		ErrorObject eObject = new ErrorObject();
		eObject.setStatus(HttpStatus.NO_CONTENT.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(eObject, HttpStatus.OK);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleApplicantNotFoundException (ApplicantNotFoundException ex) {
		ErrorObject eObject = new ErrorObject();
		eObject.setStatus(HttpStatus.NO_CONTENT.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(eObject, HttpStatus.OK);
	}


}
