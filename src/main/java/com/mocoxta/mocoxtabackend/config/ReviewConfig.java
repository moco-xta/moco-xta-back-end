package com.mocoxta.mocoxtabackend.config;

import com.mocoxta.mocoxtabackend.model.Review;
import com.mocoxta.mocoxtabackend.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ReviewConfig {

    @Bean
    CommandLineRunner commandLineRunner(ReviewRepository reviewRepository) {
        return arg -> {
            Review default_review = new Review(
                    "Federico",
                    "desmoulin.federico@gmail.com",
                    "DEVELOPER",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                    3,
                    LocalDate.of(2024, Month.JANUARY, 17)
            );

            reviewRepository.saveAll(List.of(default_review));
        };
    }
}
