package com.collabera.jump.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.collabera.jump.exceptions.DuplicateEntryException;
import com.collabera.jump.exceptions.EmployeeNotFoundException;
import com.collabera.jump.exceptions.ExceptionResponse;

@ControllerAdvice
public class EMSExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<ExceptionResponse> duplicateEmail(DuplicateEntryException e) {

		ExceptionResponse response = new ExceptionResponse("DuplicateEntryException",
				"Check Unique fields in Employees for Duplicates");

		e.printStackTrace();

		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> employeeNotFound(EmployeeNotFoundException e) {

		ExceptionResponse response = new ExceptionResponse("EmployeeNotFoundException", "Employee does not exist");

		e.printStackTrace();
		return ResponseEntity.badRequest().body(response);
	}

}
