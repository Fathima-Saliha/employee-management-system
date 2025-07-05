package com.qis.FirstSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.qis.FirstSpringBoot.utils.ErrorStructure;

//global exceptiom handler class ioc containern info pass 

@ControllerAdvice
public class GlobalExceptionHandler {

	// exception handle cheyyan illa method

	@ExceptionHandler(exception = EmployeeNotFoundException.class)
	public ResponseEntity<ErrorStructure> exceptionHandler(EmployeeNotFoundException em) {
		ErrorStructure e = new ErrorStructure();
		e.setMessage("employee not found");
		e.setRootCause(em.getMessage());
		e.setStatus(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}

}
