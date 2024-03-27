package com.mocoxta.mocoxtabackend.repositories;

import com.mocoxta.mocoxtabackend.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
