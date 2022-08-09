package com.raman.mbs.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.raman.mbs.exceptions.InvalidMovieRequestBodyException;
import com.raman.mbs.exceptions.MovieDetailsNotFoundException;

@ControllerAdvice
public class MovieExceptionHandler {
   /*
    *  Using ControllerAdvice annotation ,enables this class to handle any kind of exception
    */
	/*
	 * Need to handle MovieDetailsNotFoundException  
	 */
	@ExceptionHandler(MovieDetailsNotFoundException.class)
	public ResponseEntity handleMovieDetailsNotFoundException() {
		return new ResponseEntity("Movie Id Passed is Not Correct ", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidMovieRequestBodyException.class)
	public ResponseEntity handleMovieRequestBodyNotFoundException() {
		return new ResponseEntity("Request Body Passed is Not Correct ", HttpStatus.BAD_REQUEST);
	}
}
