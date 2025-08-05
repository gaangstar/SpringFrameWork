package com.example.demo.ex01;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ex01")
public class Ex01Controller {

    @RequestMapping(method = RequestMethod.GET, path = "/test01")
    public String test01(Ex01Dto.Test01 dto) {
        System.out.println(dto.str01);
        System.out.println(dto.num01);

        return "dto z";
    }
}
