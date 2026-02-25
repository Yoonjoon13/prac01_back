package com.example.demo.relation.a;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Aservice {
    private final ARepository aRepository;

    public void read(Long idx){
        A a = aRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("entity not found"));

        System.out.println("");
    }

    public List<ADto.ListRes> list() {
        return aRepository.findAll()
                .stream()
                .map(ADto.ListRes::from)
                .toList();
    }

}
