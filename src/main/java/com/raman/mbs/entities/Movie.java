package com.raman.mbs.entities;



import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="Cinema")
@Entity
public class Movie {
	
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int movieId;
     
     @Column(length = 50, nullable = false, unique = true)
     private String movieName;
     
     @Column(name = "movie_desc", length = 500, nullable = false)
     private String movieDescription;
     
     @Column(nullable = false)
     private LocalDateTime releaseDate;
     
     @Column(nullable = false)
     private double duration ;
     
     @Column(length = 500, nullable = false)
     private String coverPhotoUrl;
     
     @Column(length = 500, nullable = false)
     private String trailerUrl ;
 
     @ManyToOne
     @JoinColumn(name = "status_id", nullable = false)
     private Status status;
     
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ ", releaseDate=" + releaseDate + ", duration=" + duration + ", coverPhotoUrl=" + coverPhotoUrl
				+ ", trailerUrl=" + trailerUrl + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(coverPhotoUrl, duration, movieDescription, movieId, movieName, releaseDate, trailerUrl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(coverPhotoUrl, other.coverPhotoUrl) && Objects.equals(duration, other.duration)
				&& Objects.equals(movieDescription, other.movieDescription) && movieId == other.movieId
				&& Objects.equals(movieName, other.movieName) && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(trailerUrl, other.trailerUrl);
	}
     
     
     
}
