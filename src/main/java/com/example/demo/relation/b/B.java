package com.example.demo.relation.b;

import com.example.demo.relation.a.A;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class B {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String b01;
    private String b02;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_idx")
    private A a;

    public B(String b01, String b02, A a) {
        this.b01 = b01;
        this.b02 = b02;
        this.a = a;
    }
}
