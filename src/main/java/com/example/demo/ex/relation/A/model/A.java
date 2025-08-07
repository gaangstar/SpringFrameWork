package com.example.demo.ex.relation.A.model;

import com.example.demo.ex.relation.B.model.B;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;
    private String a01;
    private String a02;

    @OneToMany(mappedBy = "a")
    private List<B> bList;
}
