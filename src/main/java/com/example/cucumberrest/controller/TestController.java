package com.example.cucumberrest.controller;


import com.example.cucumberrest.service.TestExecutionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestExecutionService testExecutionService;

    @PostMapping("/run")
    public String executeTests() {
        log.info("calling TestController.executeTests()");
        return testExecutionService.executeTests();
    }
}
