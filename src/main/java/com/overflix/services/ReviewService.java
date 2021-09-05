package com.overflix.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.overflix.entities.Movie;
import com.overflix.entities.UserReview;
import com.overflix.exceptions.DataBaseException;
import com.overflix.exceptions.ResourceNotFoundException;
import com.overflix.repositories.MovieRepository;
import com.overflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Movie findById(Long id) {

		Optional<Movie> obj = movieRepository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return entity;
	}

	@Transactional
	public void delete(Long id) {

		try {
			movieRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}

	}

	@Transactional
	public UserReview insert(UserReview review) {
		
		return reviewRepository.save(review);

	}

	public List<UserReview> getReviewByIdTitle(String id) {
		return reviewRepository.findByIdTitle(id);
	}

}
