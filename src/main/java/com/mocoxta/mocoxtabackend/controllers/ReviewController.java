package com.mocoxta.mocoxtabackend.controllers;

import com.mocoxta.mocoxtabackend.models.Review;
import com.mocoxta.mocoxtabackend.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews_list")
    public List<Review> getTests() {
        return reviewService.getReviews();
    }

    @PostMapping("/add_review")
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
    };

    @DeleteMapping(path = "/delete_review/{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
    };
}
