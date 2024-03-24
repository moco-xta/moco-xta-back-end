package com.mocoxta.mocoxtabackend.services;

import com.mocoxta.mocoxtabackend.models.Test;
import com.mocoxta.mocoxtabackend.repositories.TestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> getTests() {
        return testRepository.findAll();
    }

    public void addNewTest(Test test) {
        testRepository.save(test);
    }

    @Transactional
    public void updateTest(Long testId, String title, String description) {
        Test test = testRepository.findById(testId).orElseThrow(() -> new IllegalStateException("Test with this id " + testId + " doesn't not exist."));
        if(title != null && title.length() > 0 && !Objects.equals(test.getTitle(), title)) {
            test.setTitle(title);
        };
        if(description != null && description.length() > 0 && !Objects.equals(test.getDescription(), description)) {
            test.setDescription(title);
        };
        testRepository.save(test);
    }

    public void deleteTest(Long testId) {
        if(!testRepository.existsById(testId)) {
            throw new IllegalStateException("Test with this id " + testId + " doesn't not exist.");
        };
        testRepository.deleteById(testId);
    }
}
