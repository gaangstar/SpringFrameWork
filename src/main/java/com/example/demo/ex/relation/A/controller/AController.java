package com.example.demo.ex.relation.A.controller;

import com.example.demo.ex.relation.A.model.ADto;
import com.example.demo.ex.relation.A.service.AService;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/a")
public class AController {
    private final AService aService;

    //목록 조회
    @GetMapping("/list")
    public ResponseEntity list() {
        List<ADto.ARes> response = aService.list();

        return ResponseEntity.status(200).body(response);
    }
}
