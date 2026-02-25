package com.example.demo.relation.b;

import com.example.demo.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relation")
public class BController {
    private final BService bService;

    @GetMapping("/b")
    public ResponseEntity list() {
        List<BDto.ListRes> result = bService.list();

        return ResponseEntity.ok(
                BaseResponse.success(result)
        );
    }

    @GetMapping("/b/{idx}")
    public ResponseEntity read(@PathVariable Long idx){
        bService.read(idx);

        return ResponseEntity.ok(
                BaseResponse.success("성공")
        );
    }

}
