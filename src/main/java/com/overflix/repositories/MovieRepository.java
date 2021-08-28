package com.overflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overflix.entities.Movie;

@Repository

public interface MovieRepository extends JpaRepository<Movie, Long> {

	public Movie findByIdTitle(String idTitle);

}
