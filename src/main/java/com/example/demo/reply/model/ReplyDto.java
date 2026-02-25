package com.example.demo.reply.model;

import com.example.demo.board.model.Board;
import com.example.demo.user.model.User;
import lombok.Builder;
import lombok.Getter;

public class ReplyDto {
    @Getter
    public static class RegReq {
        private Long boardIdx;
        private String contents;

        public Reply toEntity(Board board, User user) {
            return Reply.builder()
                    .contents(this.contents)
                    .board(board)
                    .user(user)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegRes {
        private Long idx;
        private Long boardIdx;
        private String contents;
        private String authorName;

        public static RegRes from(Reply entity) {
            return RegRes.builder()
                    .idx(entity.getIdx())
                    .boardIdx(entity.getBoard() != null ? entity.getBoard().getIdx() : null)
                    .contents(entity.getContents())
                    .authorName(entity.getUser() != null ? entity.getUser().getName() : null)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private Long boardIdx;
        private String contents;
        private String authorName;

        public static ListRes from(Reply entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .boardIdx(entity.getBoard() != null ? entity.getBoard().getIdx() : null)
                    .contents(entity.getContents())
                    .authorName(entity.getUser() != null ? entity.getUser().getName() : null)
                    .build();
        }
    }
}
