package ai.overmind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ai.overmind.entities.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

	Image findByIdTitle(String id);

}
