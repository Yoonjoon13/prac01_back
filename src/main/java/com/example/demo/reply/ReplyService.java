package com.example.demo.reply;

import com.example.demo.board.BoardRepository;
import com.example.demo.board.model.Board;
import com.example.demo.reply.model.Reply;
import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.UserRepository;
import com.example.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public ReplyDto.RegRes register(ReplyDto.RegReq dto) {
        Board board = boardRepository.findById(dto.getBoardIdx())
                .orElseThrow(() -> new IllegalArgumentException("Board not found."));
        Reply entity = replyRepository.save(dto.toEntity(board, getCurrentUser()));
        return ReplyDto.RegRes.from(entity);
    }

    public List<ReplyDto.ListRes> list(Long boardIdx) {
        List<Reply> replyList = replyRepository.findByBoard_IdxOrderByIdxDesc(boardIdx);
        return replyList.stream().map(ReplyDto.ListRes::from).toList();
    }

    public ReplyDto.RegRes update(Long idx, ReplyDto.RegReq dto) {
        Reply reply = replyRepository.findById(idx).orElseThrow(() -> new IllegalArgumentException("Reply not found."));
        reply.update(dto.getContents());
        return ReplyDto.RegRes.from(replyRepository.save(reply));
    }

    public void delete(Long idx) {
        replyRepository.deleteById(idx);
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new IllegalArgumentException("Authentication is required.");
        }

        String email = authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("User not found.")
        );
    }
}
