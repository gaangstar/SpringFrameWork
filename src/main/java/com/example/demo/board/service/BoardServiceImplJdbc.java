package com.example.demo.board.service;

import com.example.demo.board.model.BoardDto;
import com.example.demo.board.repository.BoardRespositoryImplJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImplJdbc {

    @Autowired
    private BoardRespositoryImplJdbc boardRepository;

    public Boolean create(BoardDto.Board dto) {
        return boardRepository.save(dto) > 0;
    }

    public BoardDto.Board read(Integer id) {
        return boardRepository.findById(id);
    }

    public List<BoardDto.Board> list() {
        return boardRepository.findAll();
    }
}
