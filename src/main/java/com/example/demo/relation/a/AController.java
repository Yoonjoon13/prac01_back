package com.example.demo.relation.a;

import com.example.demo.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/relation")
@RequiredArgsConstructor
@RestController
public class AController {
    private final Aservice aservice;

    @GetMapping("/a")
    public ResponseEntity list() {
        List<ADto.ListRes> result = aservice.list();

        return ResponseEntity.ok(
                BaseResponse.success(result)
        );
    }

    @GetMapping("/a/read/{idx}")
    public ResponseEntity read(@PathVariable Long idx){
        aservice.read(idx);

        return ResponseEntity.ok(
                BaseResponse.success("성공")
        );
    }
}
