package com.example.demo.ex.relation.B.model;

import lombok.*;

public class BDto {
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

}
