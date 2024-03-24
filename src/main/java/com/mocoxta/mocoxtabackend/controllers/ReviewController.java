package com.mocoxta.mocoxtabackend.controllers;

import com.mocoxta.mocoxtabackend.models.Review;
import com.mocoxta.mocoxtabackend.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* @CrossOrigin(origins = "https://127.0.0.1", maxAge = 3600) */
/* @CrossOrigin(origins = "http://localhost:3000") */
@RestController
@RequestMapping(path = "api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getTests() {
        return reviewService.getReviews();
    }

    @PostMapping
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
    };

    @DeleteMapping(path = "{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
    };
}
