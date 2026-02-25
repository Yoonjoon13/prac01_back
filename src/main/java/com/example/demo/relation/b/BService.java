package com.example.demo.relation.b;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BService {
    private final BRepository bRepository;

    public void read(Long idx){
        B b = bRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("entity not found"));

        System.out.println("");
    }

    public List<BDto.ListRes> list() {
        return bRepository.findAll()
                .stream()
                .map(BDto.ListRes::from)
                .toList();
    }
}
