package com.raman.mbs.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raman.mbs.dtos.DemoDTO;
import com.raman.mbs.dtos.MovieDTO;
import com.raman.mbs.entities.Movie;
import com.raman.mbs.entities.Status;
import com.raman.mbs.exceptions.MovieDetailsNotFoundException;
import com.raman.mbs.exceptions.StatusDetailsNotFoundException;
import com.raman.mbs.services.MovieService;
import com.raman.mbs.services.StatusService;
import com.raman.mbs.validators.MovieDtoValidator;

/*
 * 
 *127.0.0.1:8080/mbs/v1/movies
 *This Controller class should be invoked 
 *root uri =/mbs/v1 -> same for all resources
 */
@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private StatusService statusService;
	
	@PostMapping
	public ResponseEntity createMovie(@RequestBody MovieDTO movieDTO) throws Exception {
		/*
		 * Save this movieDTO in database .
		 * 0.Convert movieDTO to movieEntity.
		 * 1.use movieService to save it.
		 */
		MovieDtoValidator.isValid(movieDTO);
	  
		Movie movieEntity = convertMovieDTOtoEntity(movieDTO);
		Movie movieSavedEntity = movieService.acceptMovieDetails(movieEntity);
		MovieDTO responseBody  = convertMovieEntitytoMovieDTO(movieEntity);
		
		return new ResponseEntity(responseBody ,HttpStatus.CREATED);
	  
	}
	private MovieDTO convertMovieEntitytoMovieDTO(Movie savedMovieEntity) {
		MovieDTO movieDTO = new MovieDTO();
        movieDTO.setDuration(savedMovieEntity.getDuration());
        movieDTO.setMovieId(savedMovieEntity.getMovieId());
        movieDTO.setMovieDescription(savedMovieEntity.getMovieDescription());
        movieDTO.setCoverPhotoUrl(savedMovieEntity.getCoverPhotoUrl());
        movieDTO.setTrailerUrl(savedMovieEntity.getTrailerUrl());
        movieDTO.setStatusId(savedMovieEntity.getStatus().getStatusId());
        movieDTO.setMovieName(savedMovieEntity.getMovieName());
        movieDTO.setReleaseDate(savedMovieEntity.getReleaseDate());
        return movieDTO ;
	}
	private Movie convertMovieDTOtoEntity(MovieDTO movieDTO) throws Exception {
		// TODO Auto-generated method stub
		Movie movie=  new Movie();
        movie.setMovieId(movieDTO.getMovieId());
        movie.setMovieName(movieDTO.getMovieName());
        movie.setMovieDescription(movieDTO.getMovieDescription());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setTrailerUrl(movieDTO.getTrailerUrl());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setCoverPhotoUrl(movieDTO.getCoverPhotoUrl());
        /**
         * Set the status of the movie
         */
        int statusId = movieDTO.getStatusId();
        Status status = statusService.getStatusBasedOnId(statusId);
        movie.setStatus(status);
       
        return movie ;
	}
	
	@GetMapping
    public ResponseEntity getAllMovies(){
        List<Movie> movieList = movieService.getAllMovieDetails();

        List<MovieDTO> movieDTOS = new ArrayList<>();

        for(Movie movie : movieList){
            MovieDTO movieDTO = convertMovieEntitytoMovieDTO(movie);
            movieDTOS.add(movieDTO);
        }

        return new ResponseEntity(movieDTOS, HttpStatus.OK);
    }
	
	@GetMapping("/{movie_id}")
	public ResponseEntity getMovieBasedOnId(@PathVariable("movie_id") int movieId ) throws Exception
	{
	  
		Movie movie = movieService.getMovieDtails(movieId);
		
		/*
		 *In order to provide the better message to the client , we need to handle the request better. 
		 * 
		 */
		
		/*
		 * Convert movie to movieDTO
		 * 
		 */
		MovieDTO movieDTO =  convertMovieEntitytoMovieDTO(movie);
		return new ResponseEntity(movieDTO, HttpStatus.OK);
		
	  
	}
}
