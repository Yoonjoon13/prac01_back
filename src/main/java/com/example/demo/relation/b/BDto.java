package com.example.demo.relation.b;

import lombok.Builder;
import lombok.Getter;

public class BDto {

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String b01;
        private String b02;

        public static ListRes from(B entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .b01(entity.getB01())
                    .b02(entity.getB02())
                    .build();
        }
    }
}
