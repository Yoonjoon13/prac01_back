package com.example.demo.board.model;

import com.example.demo.user.model.User;
import lombok.*;

public class BoardDto {
    @Getter
    public static class RegReq {
        private String title;
        private String contents;

        public Board toEntity(User user) {
            return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .user(user)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegRes {
        private Long idx;
        private String title;
        private String contents;
        private String authorName;

        public static RegRes from(Board entity) {
            return RegRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .authorName(entity.getUser() != null ? entity.getUser().getName() : null)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String title;
        private String authorName;

        public static ListRes from(Board entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .authorName(entity.getUser() != null ? entity.getUser().getName() : null)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ReadRes {
        private Long idx;
        private String title;
        private String contents;
        private String authorName;

        public static ReadRes from(Board entity) {
            return ReadRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .authorName(entity.getUser() != null ? entity.getUser().getName() : null)
                    .build();
        }
    }
}
