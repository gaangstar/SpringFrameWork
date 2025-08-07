package com.example.demo.ex.relation.A.repository;

import com.example.demo.ex.relation.A.model.A;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ARepository extends JpaRepository<A, Integer> {
    List<A> findByA01(String a01);
}

