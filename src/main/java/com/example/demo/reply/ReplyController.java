package com.example.demo.reply;

import com.example.demo.common.model.BaseResponse;
import com.example.demo.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/reply")
@RestController
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/reg")
    public ResponseEntity reg(@RequestBody ReplyDto.RegReq dto) {
        ReplyDto.RegRes result = replyService.register(dto);
        return ResponseEntity.ok(BaseResponse.success(result));
    }

    @GetMapping("/list/{boardIdx}")
    public ResponseEntity list(@PathVariable Long boardIdx) {
        List<ReplyDto.ListRes> result = replyService.list(boardIdx);
        return ResponseEntity.ok(BaseResponse.success(result));
    }

    @PutMapping("/update/{idx}")
    public ResponseEntity update(@PathVariable Long idx, @RequestBody ReplyDto.RegReq dto) {
        ReplyDto.RegRes result = replyService.update(idx, dto);
        return ResponseEntity.ok(BaseResponse.success(result));
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity delete(@PathVariable Long idx) {
        replyService.delete(idx);
        return ResponseEntity.ok(BaseResponse.success("OK"));
    }
}
