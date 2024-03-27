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
    private String name;
    private String email;
    private String role;
    private String review;
    private Integer numberOfStars;
    private LocalDate date;
}
