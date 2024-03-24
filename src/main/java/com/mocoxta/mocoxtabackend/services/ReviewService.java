package com.mocoxta.mocoxtabackend.services;

import com.mocoxta.mocoxtabackend.models.Review;
import com.mocoxta.mocoxtabackend.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public void addReview(Review review) { reviewRepository.save(review); }

    public void deleteReview(Long id) {
        if(!reviewRepository.existsById(id)) {
            throw new IllegalStateException("Review with this id " + id + " doesn't not exist.");
        };
        reviewRepository.deleteById(id);
    }
}
