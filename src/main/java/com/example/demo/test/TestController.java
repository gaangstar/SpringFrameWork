package com.example.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    public TestController() {
        System.out.println("TestController");
    }
}
