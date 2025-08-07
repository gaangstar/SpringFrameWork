package com.example.demo.ex.relation.A.model;

import com.example.demo.ex.relation.B.model.BDto;
import lombok.*;

import java.util.*;

public class ADto {
    //응답 데이터
    @Getter
    @Builder
    public static class ARes {
        private Integer idx;
        private String a01;
        private String a02;
        private List<BDto.BRes> bResList;

        public static ARes from(A entity) {
            ARes dto = ARes.builder()
                    .idx(entity.getIdx())
                    .a01(entity.getA01())
                    .a02(entity.getA02())
                    .bResList(entity.getBList().stream().map(BDto.BRes::from).toList())
                    .build();


            return dto;
        }
    }

    //요청 데이터
    @Getter
    @Setter
    @NoArgsConstructor
    public static class AReq {
        private String a01;
        private String a02;
        private List<BDto.BReq> bReqList;

        public A toEntity() {
            A entity = A.builder()
                    .a01(a01)
                    .a02(a02)
                    .build();
            return entity;
        }
    }
}
