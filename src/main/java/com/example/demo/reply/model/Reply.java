package com.example.demo.reply.model;

import com.example.demo.board.model.Board;
import com.example.demo.common.model.BaseEntity;
import com.example.demo.user.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "board_idx")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "reply_user")
    private User user;

    public void update(String contents) {
        this.contents = contents;
    }
}
