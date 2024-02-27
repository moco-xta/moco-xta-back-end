package com.mocoxta.mocoxtabackend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Review {

    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String role;
    private String review;
    private Integer number_of_stars;
    private LocalDate date;

    public Review() {
    }

    public Review(String name, String email, String role, String review, Integer number_of_stars, LocalDate date) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.review = review;
        this.number_of_stars = number_of_stars;
        this.date = date;
    }

    public Review(Long id, String name, String email, String role, String review, Integer number_of_stars, LocalDate date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.review = review;
        this.number_of_stars = number_of_stars;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getNumber_of_stars() {
        return number_of_stars;
    }

    public void setNumber_of_stars(Integer number_of_stars) {
        this.number_of_stars = number_of_stars;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", review='" + review + '\'' +
                ", number_of_stars=" + number_of_stars +
                ", date=" + date +
                '}';
    }
}
