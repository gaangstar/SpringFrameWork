package com.example.demo.ex.relation.B.model;

import com.example.demo.ex.relation.A.model.A;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class B {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;
    private String b01;
    private String b02;

    @ManyToOne
    @JoinColumn(name = "a_idx")
    private A a;
}
