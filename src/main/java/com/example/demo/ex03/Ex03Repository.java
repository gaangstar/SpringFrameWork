package com.example.demo.ex03;

import org.mariadb.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class Ex03Repository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer save(String str01, String str02) {
        String sql = "INSERT INTO test (str01, str02) VALUES (?, ?)";
        Integer result = jdbcTemplate.update(sql, str01, str02);

        return result;
    }
}
