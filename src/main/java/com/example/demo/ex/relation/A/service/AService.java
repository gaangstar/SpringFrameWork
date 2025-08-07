package com.example.demo.ex.relation.A.service;

import com.example.demo.ex.relation.A.model.A;
import com.example.demo.ex.relation.A.model.ADto;
import com.example.demo.ex.relation.A.repository.ARepository;

import com.example.demo.ex.relation.B.model.BDto;
import com.example.demo.ex.relation.B.repository.BRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AService {
    private final ARepository aRepository;
    private final BRepository bRepository;

    //등록
    public void register(ADto.AReq dto) {
        A a = aRepository.save(dto.toEntity());
        for(BDto.BReq bDto : dto.getBReqList()) {
            bRepository.save(bDto.toEntity(a));
        }
    }

    //목록 조회
    public List<ADto.ARes> list() {
        List<A> result = aRepository.findAll();
        return result.stream().map(ADto.ARes::from).toList();
    }
}
