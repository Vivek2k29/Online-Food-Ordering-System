package com.food.service;

import java.util.List;

import com.food.Exception.ReviewException;
import com.food.model.Review;
import com.food.model.User;
import com.food.request.ReviewRequest;

public interface ReviewSerive {
	
    public Review submitReview(ReviewRequest review,User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
}
