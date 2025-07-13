package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
