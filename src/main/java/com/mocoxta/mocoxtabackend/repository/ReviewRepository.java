package com.mocoxta.mocoxtabackend.repository;

import com.mocoxta.mocoxtabackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
