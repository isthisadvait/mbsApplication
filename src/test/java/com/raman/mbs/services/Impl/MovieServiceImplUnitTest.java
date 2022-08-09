package com.raman.mbs.services.Impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raman.mbs.daos.MovieDao;
import com.raman.mbs.entities.Movie;
import com.raman.mbs.entities.Status;

@SpringBootTest
public class MovieServiceImplUnitTest {
	/*
	 * This class will be used for unit testing  of MovieServiceImpl  class
	 * 
	 */
	/*
	 * This will create a mocked MovieDao object.
	 * 
	 */
	@Mock
	private MovieDao movieDao;
	/*
	 * I need to create MovieServiceImpl Object which uses mocked MovieDao.
	 * 
	 */
	
	@InjectMocks
	private MovieServiceImpl movieService;
	
	private Movie movie;
	private Movie savedMovie;
	@BeforeEach
	public void beforeEach() {

		movie = new Movie();
		movie.setMovieName("Charlie777");
		movie.setMovieDescription("This Movie can compel you to love .It can generate the capacity to Love");
		movie.setReleaseDate(LocalDateTime.of(2022,8,05,17,20));
		movie.setDuration(230);
		movie.setCoverPhotoUrl("www.Charlie777/cover-photo-url");
		movie.setTrailerUrl("www.Charlie777/trailer-url");
		
		savedMovie = new Movie();
		savedMovie.setMovieId(1);
		savedMovie.setMovieName("Charlie777");
		savedMovie.setMovieDescription("This Movie can compel you to love .It can generate the capacity to Love");
		savedMovie.setReleaseDate(LocalDateTime.of(2022,8,05,17,20));
		savedMovie.setDuration(230);
		savedMovie.setCoverPhotoUrl("www.Charlie777/cover-photo-url");
		savedMovie.setTrailerUrl("www.Charlie777/trailer-url");
		
		
		
		
		
		
	}
	
	
	@Test
	public void testAcceptMovieDetails() {
	  // Create  Data - Done in beforeEach() method
		
	  /*
	   * As acceptMovieDetails uses movieDao , here we need to define the behavior of mocked movieDao Object
	   */
		Mockito.when(movieDao.save(movie)).thenReturn(savedMovie);
		
	  // Execute Methods
		
		Movie savMovie = movieService.acceptMovieDetails(movie);
	  // Assertions
		Assertions.assertNotNull(savMovie);
		Assertions.assertEquals(1,savMovie.getMovieId());
		
	}
	
	// Test Case for get Movie Details
	/*
	 * It takes an Id and return the movie Object 
	 */

	@Test
	public void testGetMovieDetails() throws Exception {
		// set up data -Already Done by before each

			
		//define behavior
		Mockito.when(movieDao.findById(1)).thenReturn(Optional.of(savedMovie));
		
		//execute
		Movie movie = movieService.getMovieDtails(1);
		//assertion
		Assertions.assertNotNull(movie);

		
		
	}

}
