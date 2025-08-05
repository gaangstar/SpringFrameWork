package com.example.demo.board.controller;

import com.example.demo.board.model.BoardDto;
import com.example.demo.board.service.BoardServiceImplJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardServiceImplJdbc boardServiceImplJdbc;

    //게시글 작성
    @PostMapping("/create")
    public ResponseEntity Create(@RequestBody BoardDto.Board dto) {
        Boolean result = boardServiceImplJdbc.create(dto);

        if(result) {
            return ResponseEntity.status(200).body(dto);
        }
        return ResponseEntity.status(400).body("failed");
    }

    //게시글 조회
    @GetMapping("/read")
    public ResponseEntity Read(Integer id) {
        BoardDto.Board result = boardServiceImplJdbc.read(id);

        return ResponseEntity.status(200).body(result);
    }

    //게시글 목록 조회
    @GetMapping("/list")
    public ResponseEntity List() {
        List<BoardDto.Board> result = boardServiceImplJdbc.list();

        return ResponseEntity.status(200).body(result);
    }
}
