package com.mocoxta.mocoxtabackend.controller;

import com.mocoxta.mocoxtabackend.model.Test;
import com.mocoxta.mocoxtabackend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<Test> getTests() {
        return testService.getTests();
    }

    @PostMapping
    public void addNewTest(@RequestBody Test test) {
        testService.addNewTest(test);
    };

    @PutMapping(path = "{testId}")
    public void updateTest(
            @PathVariable("testId") Long testId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description
    ) {
        testService.updateTest(testId, title, description);
    }

    @DeleteMapping(path = "{testId}")
    public void deleteTest(@PathVariable("testId") Long testId) {
        testService.deleteTest(testId);
    };
}
