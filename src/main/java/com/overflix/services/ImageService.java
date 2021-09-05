package com.overflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.overflix.entities.Image;
import com.overflix.repositories.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
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


}
