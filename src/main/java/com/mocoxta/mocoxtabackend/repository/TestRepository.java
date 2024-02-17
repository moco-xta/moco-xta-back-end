package com.mocoxta.mocoxtabackend.repository;

import com.mocoxta.mocoxtabackend.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
