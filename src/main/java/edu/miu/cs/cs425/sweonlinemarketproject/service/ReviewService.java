package edu.miu.cs.cs425.sweonlinemarketproject.service;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();

    Review getReviewById(long id);

    Review saveReview(Review review);

    Review updateReview(long id, Review review);

    void deleteReviewById(long id);

}
