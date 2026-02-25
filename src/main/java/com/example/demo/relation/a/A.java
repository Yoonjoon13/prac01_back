package com.example.demo.relation.a;

import com.example.demo.relation.b.B;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String a01;

    @OneToMany(mappedBy = "a")
    private List<B> bList;

    public A(String a01) {
        this.a01 = a01;
    }
}
