package com.example.demo.board.repository;

import com.example.demo.board.model.BoardDto;
import org.mariadb.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRespositoryImplJdbc implements BoardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //게시글 생성
    @Override
    public Integer save(BoardDto.Board dto) {
        String sql = "INSERT INTO board(title, contents) VALUES (?, ?)";
        Integer result = jdbcTemplate.update(sql, dto.getTitle(), dto.getContents());

        return result;
    }

    //게시글 상세 조회
    @Override
    public BoardDto.Board findById(Integer id) {
        String sql = "SELECT * FROM board WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BoardDto.Board.class), id);
    }

    //게시글 목록 조회
    @Override
    public List<BoardDto.Board> findAll() {
        String sql = "SELECT * FROM board";

        return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDto.Board.class));
    }
}
