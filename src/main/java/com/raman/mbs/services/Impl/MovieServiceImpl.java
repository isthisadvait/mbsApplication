package com.raman.mbs.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raman.mbs.daos.MovieDao;
import com.raman.mbs.entities.Movie;
import com.raman.mbs.exceptions.MovieDetailsNotFoundException;
import com.raman.mbs.exceptions.StatusDetailsNotFoundException;
import com.raman.mbs.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
    
	@Autowired
	private MovieDao movieDao;
	
	@Override
	public Movie acceptMovieDetails(Movie movie) {
		return movieDao.save(movie);
	}

	@Override
	public Movie getMovieDtails(int id) throws Exception {
		Movie movie = movieDao.findById(id).orElseThrow(()->new MovieDetailsNotFoundException("<Movie Not found for provided Movie id"));
		return movie;
	}


	@Override
	public Movie updateMovieDetails(int movieId, Movie movie) throws Exception{
		//first fetched the saved movie using movie Id
		Movie savedMovie = movieDao.findById(movieId).orElseThrow(()->new MovieDetailsNotFoundException("<Movie Not found for provided Movie id"));
		
		//update the movie object
		if(movie.getMovieName()!=null){
            savedMovie.setMovieName(movie.getMovieName());
        }
        if(movie.getDuration()>0){
            savedMovie.setDuration(movie.getDuration());
        }

        if(movie.getMovieDescription()!=null){
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }

        if(movie.getCoverPhotoUrl()!=null){
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        }

        if(movie.getTrailerUrl()!=null){
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
        }

        if(movie.getReleaseDate()!=null){
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }

        if(movie.getStatus()!=null){
            savedMovie.setStatus(movie.getStatus());
        }

        //Save it back in the database

       return movieDao.save(savedMovie);
    }

    
		
	

	@Override
	public boolean deleteMovie(int id) {
		 movieDao.deleteById(id);
	     return true;
	}

	@Override
	public List<Movie> getAllMovieDetails() {
		return movieDao.findAll();
	}
	

}
