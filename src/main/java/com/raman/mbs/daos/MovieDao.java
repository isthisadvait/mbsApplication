package com.raman.mbs.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raman.mbs.entities.Movie;


// All the Basic CRUD operations will be available now .To have more queries ,We can define the signature of the
//methods in this interface. We have to follow some naming conventions like
// find<EntityName>By<ColumnName>

public interface MovieDao extends JpaRepository<Movie,Integer> {
	
   public Movie findMovieByMovieName(String movieName);
   
   public Movie findMovieByMovieNameAndDuration(String movieName, double duration);
   
   public List<Movie> findByDurationGreaterThanEqual(double duration);
   
   public List<Movie> findByMovieNameContaining(String movieString);
   
   public List<Movie> findByMovieNameIgnoreCase(String movieString);
   
   
}
