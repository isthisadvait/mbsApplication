package com.raman.mbs.services.Impl;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raman.mbs.entities.Movie;
import com.raman.mbs.entities.Status;
import com.raman.mbs.services.MovieService;
import com.raman.mbs.services.StatusService;

@SpringBootTest
public class MovieServiceImplTest {
	/*
	 * This class will be used to test the methods of MovieServiceImpl 
	 * 
	 */
	/*
	 * Write a method to test acceptMovieDetaisls.
	 * 
	 */
	@Autowired
	private MovieServiceImpl movieService;
	
	private Movie movie;
	
	@Autowired
	private StatusServiceImpl statusService;
	@BeforeEach
	public void beforeEach() {
		Status status = new Status();
		status.setStatusName("Released");
		statusService.acceptStatusDetails(status);
		movie = new Movie();
		movie.setMovieName("Charlie777");
		movie.setMovieDescription("This Movie can compel you to love .It can generate the capacity to Love");
		movie.setReleaseDate(LocalDateTime.of(2022,8,05,17,20));
		movie.setDuration(230);
		movie.setCoverPhotoUrl("www.Charlie777/cover-photo-url");
		movie.setTrailerUrl("www.Charlie777/trailer-url");
		movie.setStatus(status);
		
		
	}
	@Test
	public void testAcceptMovieDetails() {
		/*
		 * 1.MovieServiceImpl object to test the method
		 * 2.Creation of data
		 * 3.Execution Of method
		 * 4.Assertion method
		 */
		Movie actualMovieObject = movieService.acceptMovieDetails(movie);
		
		Assertions.assertNotNull(actualMovieObject);
		Assertions.assertEquals(2,actualMovieObject.getMovieId());
		
	}
	
	// Test Case for get Movie Details
		/*
		 * It takes an Id and return the movie Object 
		 */
	@Test
	public void testGetMovieDetails() throws Exception {
		// set up data ,we need to store something in data base - done in previous test
		//execute
		Movie movie = movieService.getMovieDtails(2);
		//assertion
		Assertions.assertNotNull(movie);

		
		
	}

}
