package com.raman.mbs.services;

import java.util.List;

import com.raman.mbs.entities.Movie;

public interface MovieService {
	
	public Movie acceptMovieDetails(Movie movie) ;
	
	public Movie getMovieDtails(int id) throws Exception;
	
	public Movie updateMovieDetails(int movieId , Movie movie) throws Exception;
	
	public boolean deleteMovie(int id);
	
	public List<Movie> getAllMovieDetails();
	
}
