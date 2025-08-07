package com.example.demo.ex.relation.B.model;

import com.example.demo.ex.relation.A.model.A;
import lombok.*;

public class BDto {

    //응답 데이터
    @Getter
    @Builder
    public static class BRes {
        private Integer idx;
        private String b01;
        private String b02;

        public static BDto.BRes from(B entity) {
            BDto.BRes dto  = BDto.BRes.builder()
                    .idx(entity.getIdx())
                    .b01(entity.getB01())
                    .b02(entity.getB02())
                    .build();

            return dto;
        }
    }

    //요청 데이터
    @Getter
    @Setter
    @NoArgsConstructor
    public static class BReq {
        private String b01;
        private String b02;

        public B toEntity(A a) {
            return B.builder()
                    .b01(b01)
                    .b02(b02)
                    .a(a)
                    .build();
        }
    }
}
