package ai.overmind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ai.overmind.entities.Movie;

@Repository

public interface MovieRepository extends JpaRepository<Movie, Long> {

	public Movie findByIdTitle(String idTitle);

}
