package com.raman.mbs.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.raman.mbs.exceptions.StatusDetailsNotFoundException;

@ControllerAdvice
public class StatusExceptionHandler {
	
	@ExceptionHandler(StatusDetailsNotFoundException.class)
	public ResponseEntity handleStausDetailsNotFoundException() {
		return new ResponseEntity("Status Id Passed is Not Correct ", HttpStatus.BAD_REQUEST);
	}
	

}
