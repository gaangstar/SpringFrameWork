package com.example.demo.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ex03")
public class Ex03Controller {

    @Autowired
    Ex03Service ex03Service;

    @PostMapping("/test01")
    public String test01(String str01, String str02) {
        ex03Service.save(str01, str02);
        return "insert success";
    }
}
