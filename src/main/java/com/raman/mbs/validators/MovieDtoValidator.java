package com.raman.mbs.validators;

import com.raman.mbs.dtos.MovieDTO;
import com.raman.mbs.exceptions.InvalidMovieRequestBodyException;

public class MovieDtoValidator {
	
	public static boolean isValid(MovieDTO movieDTO) throws InvalidMovieRequestBodyException {
		if(movieDTO.getMovieName()==null || movieDTO.getMovieName() == "" ) {
			throw new InvalidMovieRequestBodyException("Movie Name is empty or null");
		}
		if(movieDTO.getMovieDescription()==null || movieDTO.getMovieDescription()=="") {
			
			throw new InvalidMovieRequestBodyException("Movie Request is empty or null");
			
		}
		if(movieDTO.getCoverPhotoUrl()==null || movieDTO.getCoverPhotoUrl()=="") {
			throw new InvalidMovieRequestBodyException("Cover Photo URL is empty or null");
		}
		if( movieDTO.getDuration()<0.0)
		{
			throw new InvalidMovieRequestBodyException("Duration Provided is not valid");
		}
		if( movieDTO.getStatusId() <= 0) {
			throw new InvalidMovieRequestBodyException("Status Id is not valid");
		}
		return true;
	}

}
