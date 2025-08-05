package com.example.demo.board.repository;

import com.example.demo.board.model.BoardDto;

import java.util.List;

public interface BoardRepository {
    Integer save(BoardDto.Board dto);
    BoardDto.Board findById(Integer id);
    List<BoardDto.Board> findAll();
}
