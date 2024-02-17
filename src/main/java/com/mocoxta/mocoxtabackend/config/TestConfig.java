package com.mocoxta.mocoxtabackend.config;

import com.mocoxta.mocoxtabackend.model.Test;
import com.mocoxta.mocoxtabackend.repository.TestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TestConfig {

    @Bean
    CommandLineRunner commandLineRunner(TestRepository testRepository) {
        return arg -> {
            Test default_test = new Test(
                    1L,
                    "Default title",
                    LocalDate.of(2024, Month.JANUARY, 17),
                    "This is the description of the default test"
            );

            testRepository.saveAll(List.of(default_test));
        };
    }
}
