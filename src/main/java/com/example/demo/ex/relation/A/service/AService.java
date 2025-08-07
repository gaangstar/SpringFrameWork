package com.example.demo.ex.relation.A.service;

import com.example.demo.ex.relation.A.model.A;
import com.example.demo.ex.relation.A.model.ADto;
import com.example.demo.ex.relation.A.repository.ARepository;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AService {
    private final ARepository aRepository;

    public List<ADto.ARes> list() {
        List<A> result = aRepository.findAll();
        return result.stream().map(ADto.ARes::from).toList();
    }
}
