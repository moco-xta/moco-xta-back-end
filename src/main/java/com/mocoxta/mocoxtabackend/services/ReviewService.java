package com.mocoxta.mocoxtabackend.services;

import com.mocoxta.mocoxtabackend.models.Review;
import com.mocoxta.mocoxtabackend.models.User;
import com.mocoxta.mocoxtabackend.repositories.ReviewRepository;
import com.mocoxta.mocoxtabackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public List<Review.ReviewResponse> getReviews() {
        List<Review> reviews = reviewRepository.findAll();
        List<Review.ReviewResponse> ReviewsResponse = reviews.stream().map(review -> {
            User user = userRepository.getReferenceById(review.getUser().getId());
            Review.ReviewResponse reviewResponse = Review.ReviewResponse.builder()
                    .id(review.getId())
                    .review(review.getReview())
                    .role(review.getRole())
                    .rating(review.getRating())
                    .date(review.getDate())
                    .firstName(user.getFirstName())
                    .build();
            return setReviewResponse(review, user);
        }).collect(Collectors.toList());;
        return ReviewsResponse;
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
        return setReviewResponse(savedReview, user);
    }

    private Review.ReviewResponse setReviewResponse(Review review, User user) {
        Review.ReviewResponse reviewResponse = Review.ReviewResponse.builder()
                .id(review.getId())
                .review(review.getReview())
                .role(review.getRole())
                .rating(review.getRating())
                .date(review.getDate())
                .firstName(user.getFirstName())
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
