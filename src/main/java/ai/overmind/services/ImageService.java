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
import ai.overmind.repositories.ImageRepository;
import ai.overmind.repositories.MovieRepository;
import ai.overmind.repositories.ReviewRepository;

@Service
public class ImageService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ReviewRepository reviewRepository;

	
	public List<Image> getAllImages() {
		return imageRepository.findAll();
	}
	
	@Transactional
	public Image insert(Image image) {

		return imageRepository.save(image);

	}

	public Image getImageByIdTitle(String id) {
		return imageRepository.findByIdTitle(id);
	}

	/*
	 * @Transactional public JornadaTrabalho update(Long id, JornadaTrabalho
	 * jornadaTrabalho) {
	 * 
	 * try {
	 * 
	 * JornadaTrabalho entity = jornadaTrabalhoRepository.getOne(id);
	 * copyDtoToEntity(jornadaTrabalho, entity); entity =
	 * jornadaTrabalhoRepository.save(entity); return entity;
	 * 
	 * } catch (EntityNotFoundException e) { throw new
	 * ResourceNotFoundException("Id not found " + id); }
	 * 
	 * }
	 */

}
