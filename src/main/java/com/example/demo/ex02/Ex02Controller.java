package com.example.demo.ex02;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex02")
public class Ex02Controller {
    @GetMapping("/test01")
    public String test01() {
        return "test01";
    }

    @GetMapping("/test02")
    public Ex02Dto.Res test02() {
        Ex02Dto.Res response = new Ex02Dto.Res();
        response.setData01(10);
        response.setData02(20);
        return response;
    }

    @GetMapping("/test03")
    public ResponseEntity test03() {

        Ex02Dto.Res response = new Ex02Dto.Res();
        response.setData01(30);
        response.setData02(40);
        return ResponseEntity.status(200).body(response);
    }
}
