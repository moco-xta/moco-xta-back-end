package com.mocoxta.mocoxtabackend.repositories;

import com.mocoxta.mocoxtabackend.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
