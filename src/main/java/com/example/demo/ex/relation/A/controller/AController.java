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

    //등록
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ADto.AReq dto) {
        aService.register(dto);
        System.out.println(dto.getBReqList());
        return ResponseEntity.status(200).body("등록 성공");
    }

    //목록 조회
    @GetMapping("/list")
    public ResponseEntity<List<ADto.ARes>> list() {
        List<ADto.ARes> response = aService.list();

        return ResponseEntity.status(200).body(response);
    }
}
