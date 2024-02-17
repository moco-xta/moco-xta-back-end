package com.mocoxta.mocoxtabackend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Test {

    @Id
    @SequenceGenerator(
            name = "test_sequence",
            sequenceName = "test_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "test_sequence"
    )
    private Long id;
    private String title;
    private LocalDate date_of_creation;
    private String description;

    public Test() {
    }

    public Test(String title, LocalDate date_of_creation, String description) {
        this.title = title;
        this.date_of_creation = date_of_creation;
        this.description = description;
    }

    public Test(Long id, String title, LocalDate date_of_creation, String description) {
        this.id = id;
        this.title = title;
        this.date_of_creation = date_of_creation;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate_of_creation() {
        return date_of_creation;
    }

    public void setDate_of_creation(LocalDate date_of_creation) {
        this.date_of_creation = date_of_creation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date_of_creation=" + date_of_creation +
                ", description='" + description + '\'' +
                '}';
    }
}
