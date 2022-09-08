package com.uc.universitycourse.exception;

	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;
	import org.springframework.web.context.request.WebRequest;
	import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request){
	System.out.println("ss");
	ErrorObject error = new ErrorObject();
	 error.setStatus(HttpStatus.BAD_REQUEST.value());
	 error.setMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}

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
