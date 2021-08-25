package ai.overmind.services;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ai.overmind.entities.Image;
import ai.overmind.entities.Movie;
import ai.overmind.entities.UserReview;
import ai.overmind.exceptions.DataBaseException;
import ai.overmind.exceptions.ResourceAlreadyExistException;
import ai.overmind.exceptions.ResourceNotFoundException;
import ai.overmind.mappedIMDB.Review;
import ai.overmind.repositories.ImageRepository;
import ai.overmind.repositories.MovieRepository;
import ai.overmind.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ImageRepository imageRepository;
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

	/*@Transactional
	public JornadaTrabalho update(Long id, JornadaTrabalho jornadaTrabalho) {

		try {

			JornadaTrabalho entity = jornadaTrabalhoRepository.getOne(id);
			copyDtoToEntity(jornadaTrabalho, entity);
			entity = jornadaTrabalhoRepository.save(entity);
			return entity;

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}

	}*/

}
