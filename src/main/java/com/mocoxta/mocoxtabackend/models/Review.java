package com.mocoxta.mocoxtabackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String review;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private Integer rating;
    @Column(nullable = false)
    private LocalDate date;
    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewRequest {

        private String review;
        private String role;
        private Integer rating;
        private LocalDate date;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewResponse {

        private Long id;
        private String review;
        private String role;
        private Integer rating;
        private LocalDate date;
        private User.UserData userData;
    }
}
