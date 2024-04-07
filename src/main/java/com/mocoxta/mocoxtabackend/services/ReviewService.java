package com.mocoxta.mocoxtabackend.services;

import com.mocoxta.mocoxtabackend.models.Review;
import com.mocoxta.mocoxtabackend.models.User;
import com.mocoxta.mocoxtabackend.repositories.ReviewRepository;
import com.mocoxta.mocoxtabackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review.ReviewResponse addReview(Review.ReviewRequest reviewRequest, String token) {
        User user = jwtService.extractUser(token);
        Review review = Review.builder()
                .review(reviewRequest.getReview())
                .role(reviewRequest.getRole())
                .rating(reviewRequest.getRating())
                .date(reviewRequest.getDate())
                .user(user)
                .build();
        Review savedReview = reviewRepository.save(review);
        user.setReview(savedReview);
        userRepository.save(user);
        User.UserData userData = jwtService.extractUserData(token);
        Review.ReviewResponse reviewResponse = Review.ReviewResponse.builder()
                .id(savedReview.getId())
                .review(savedReview.getReview())
                .role(savedReview.getRole())
                .rating(savedReview.getRating())
                .date(savedReview.getDate())
                .userData(userData)
                .build();
        return reviewResponse;
    }

    public void deleteReview(Long id) {
        if(!reviewRepository.existsById(id)) {
            throw new IllegalStateException("Review with this id " + id + " doesn't not exist.");
        };
        reviewRepository.deleteById(id);
    }
}
