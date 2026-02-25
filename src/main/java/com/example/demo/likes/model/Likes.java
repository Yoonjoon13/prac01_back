package com.example.demo.likes.model;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import com.example.demo.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Likes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_author")
    private Board boardr;


}
