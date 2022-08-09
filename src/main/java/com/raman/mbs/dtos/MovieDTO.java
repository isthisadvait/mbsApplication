package com.raman.mbs.dtos;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raman.mbs.entities.Status;

public class MovieDTO {
	
	@JsonProperty("movie_id")
    private int movieId;
    
	@JsonProperty("movie_name")
    private String movieName;
    
	@JsonProperty("movie_description")
    private String movieDescription;
    
	@JsonProperty("release_date")
    private LocalDateTime releaseDate;
    

    private double duration ;
    
	@JsonProperty("cover_photo_url")
    private String coverPhotoUrl;
    
	@JsonProperty("trailer_url")
    private String trailerUrl ;
   
	@JsonProperty("status_id")
	private int statusId;
  

	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getMovieDescription() {
		return movieDescription;
	}


	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}


	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}


	public double getDuration() {
		return duration;
	}


	public void setDuration(double duration) {
		this.duration = duration;
	}


	public String getCoverPhotoUrl() {
		return coverPhotoUrl;
	}


	public void setCoverPhotoUrl(String coverPhotoUrl) {
		this.coverPhotoUrl = coverPhotoUrl;
	}


	public String getTrailerUrl() {
		return trailerUrl;
	}


	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}


	@Override
	public int hashCode() {
		return Objects.hash(coverPhotoUrl, duration, movieDescription, movieId, movieName, releaseDate, statusId,
				trailerUrl);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieDTO other = (MovieDTO) obj;
		return Objects.equals(coverPhotoUrl, other.coverPhotoUrl)
				&& Double.doubleToLongBits(duration) == Double.doubleToLongBits(other.duration)
				&& Objects.equals(movieDescription, other.movieDescription) && movieId == other.movieId
				&& Objects.equals(movieName, other.movieName) && Objects.equals(releaseDate, other.releaseDate)
				&& statusId == other.statusId && Objects.equals(trailerUrl, other.trailerUrl);
	}


	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ ", releaseDate=" + releaseDate + ", duration=" + duration + ", coverPhotoUrl=" + coverPhotoUrl
				+ ", trailerUrl=" + trailerUrl + ", statusId=" + statusId + "]";
	}



    
	

}
