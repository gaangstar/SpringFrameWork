package com.example.demo.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ex03Service {
    @Autowired
    Ex03Repository ex03Repository;

    public Boolean save(String str01, String str02) {
        return ex03Repository.save(str01, str02) > 0;
    }
}
