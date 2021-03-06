package com.overflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overflix.entities.UserReview;

@Repository

public interface ReviewRepository extends JpaRepository<UserReview, Long> {

	List<UserReview> findByIdTitle(String id);

}
