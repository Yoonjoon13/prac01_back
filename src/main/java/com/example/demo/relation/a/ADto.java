package com.example.demo.relation.a;

import lombok.Builder;
import lombok.Getter;

public class ADto {

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String a01;

        public static ListRes from(A entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .a01(entity.getA01())
                    .build();
        }
    }
}
