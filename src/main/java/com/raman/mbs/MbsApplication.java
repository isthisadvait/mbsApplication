package com.raman.mbs;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.raman.mbs.daos.MovieDao;
import com.raman.mbs.entities.Movie;
import com.raman.mbs.entities.Status;
import com.raman.mbs.services.MovieService;
import com.raman.mbs.services.StatusService;
import com.raman.mbs.services.Impl.MovieServiceImpl;
import com.raman.mbs.services.Impl.StatusServiceImpl;

@SpringBootApplication
public class MbsApplication {
	/*
	 *Writing the logs  
	 * Initialize the Logger for MbsApplication Class
	 */
	

	private static final Logger LOGGER = LoggerFactory.getLogger(MbsApplication.class);
	
	public static void main(String[] args) throws Exception{
		
		//I got the hold of ctx
		ApplicationContext ctx = SpringApplication.run(MbsApplication.class, args);
		/*
	
		//Got the hold of MovieDao Bean
		MovieDao movieDao  = ctx.getBean(MovieDao.class);
		
		System.out.println(movieDao);
		System.out.println("Hello Students");
		
		Movie movie = new Movie();
		movie.setMovieName("Charlie777");
		movie.setMovieDescription("This Movie can compel you to love .It can generate the capacity to Love");
		movie.setReleaseDate(LocalDateTime.of(2022,07,07,17,20));
		movie.setDuration(230);
		movie.setCoverPhotoUrl("www.Charlie777/cover-photo-url");
		movie.setTrailerUrl("www.Charlie777/trailer-url");
		
		System.out.println("Before Movie is Stored");
		System.out.println(movie);
		System.out.println("After Movie is Stored");
		
		//Creating movie using MovieDao
		System.out.println("<-------------C of CRUD by Default------------>");
		Movie savedMovie = movieDao.save(movie);
		System.out.println(savedMovie);
		
		//Searching movie based on id using Dao
		System.out.println("<--------------Searching by Default------------>");
		Movie searchedMovie = movieDao.findById(savedMovie.getMovieId()).get();
		System.out.println(searchedMovie);
		
		//Update Movie
		System.out.println("<---------------U of CRUD by Default------------>");
		searchedMovie.setDuration(250);
		Movie updatedMovie = movieDao.save(searchedMovie);
		
		//Delete Movie
		System.out.println("<---------------D of CRUD by Default------------->");
		//movieDao.deleteById(updatedMovie.getMovieId());
		
		//search Movie by Movie name
		System.out.println("<---------------Searching by defining Methods------------->");
		Movie movieName = movieDao.findMovieByMovieName(updatedMovie.getMovieName());
		System.out.println(movieName);
		
		//some combined queries
		*/
	
		/*
		                     // Testing Status Service
		
		StatusService statusService = ctx.getBean(StatusServiceImpl.class);
		System.out.println("<--------------------- "+ statusService +"----------------->");
		
		Status status = new Status();
		status.setStatusName("Released");
		statusService.acceptStatusDetails(status);
		
		//Status savedStatus = statusService.getStatusBasedOnId(2);
		
		//System.out.println(savedStatus);
		
		Status status1 = new Status();
		status1.setStatusName("Blocked");
		statusService.acceptStatusDetails(status1);
		
		
		List<Status> list = statusService.getAllStatus();
		System.out.println(list);
		
		
		                       // Testing Movie Service
		MovieService movieService = ctx.getBean(MovieServiceImpl.class);
		System.out.println("<--------------------- "+ movieService +"----------------->");
		
		Movie movie2 = new Movie();
		movie2.setMovieName("Charlie777");
		movie2.setMovieDescription("This Movie can compel you to love .It can generate the capacity to Love");
		movie2.setReleaseDate(LocalDateTime.of(2022,8,05,17,20));
		movie2.setDuration(230);
		movie2.setCoverPhotoUrl("www.Charlie777/cover-photo-url");
		movie2.setTrailerUrl("www.Charlie777/trailer-url");
		movie2.setStatus(status);
		
		movieService.acceptMovieDetails(movie2);
		
		Movie movie1 = new Movie();
		movie1.setMovieName("Rocketry");
		movie1.setMovieDescription("This Movie can compel you to do for country  .It can generate the capacity to hate");
		movie1.setReleaseDate(LocalDateTime.of(2022,8,05,17,20));
		movie1.setDuration(230);
		movie1.setCoverPhotoUrl("www.Rocketry777/cover-photo-url");
		movie1.setTrailerUrl("www.Rocketry/trailer-url");
		movie1.setStatus(status1);
		
		movieService.acceptMovieDetails(movie1);
		
		movie1=movieService.getMovieDtails(1);
		System.out.println(movie1);
		
		
		
		
	   // Writing different levels of Log
		
		LOGGER.debug("I am Writing a debug Log");
		LOGGER.info("I am writng a Info Log");
		LOGGER.warn("I am writing a warn Log");
        LOGGER.error("I am writing an error log");
        
		*/
		
	}

}
